package com.todoapp.jwt.resource;

import com.todoapp.dto.UserDto;
import com.todoapp.jwt.JwtInMemoryUserDetailsService;
import com.todoapp.jwt.JwtTokenUtil;
import com.todoapp.jwt.JwtUserDetails;
import com.todoapp.service.UsersFetchService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class JwtAuthenticationRestController {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersFetchService usersFetchService;

    @Autowired
    private JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
            throws AuthenticationException {

        log.warn("Jwt Token Request : {}", authenticationRequest);

        List<UserDto> users = usersFetchService.fetchAllUsers();
        logger.warn("User details dto's - {}", users);
        jwtInMemoryUserDetailsService.setUsers(users);
        List<JwtUserDetails> jswUsersList = new ArrayList<>();
        users.forEach(user -> {
            jswUsersList.add(new JwtUserDetails(UUID.randomUUID(), user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassword()), "ROLE_USER_2"));
        });
        jwtInMemoryUserDetailsService.setJswUsersList(jswUsersList);

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }

    @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }
}
