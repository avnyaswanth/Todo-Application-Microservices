package com.todoapp.jwt;

import java.util.*;

import com.todoapp.dto.UserDto;
import com.todoapp.service.UsersFetchService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Getter
@Setter
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  private List<JwtUserDetails> jswUsersList = new ArrayList<>();

  private List<UserDto> users;

  @Autowired
  UsersFetchService usersFetchService;

//  @PostConstruct
//  void init() {
//    users = usersFetchService.fetchAllUsers();
//    users.forEach(user -> {
//            jswUsersList.add(new JwtUserDetails(user.getUserId(), user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassword()), "ROLE_USER_2"));
//        });
//  }

//  static {
//    jswUsersList.add(new JwtUserDetails(1L, "in28minutes",
//        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//
//    jswUsersList.add(new JwtUserDetails(2L, "hacker",
//        "$2a$10$biZo1U.MzPcfOBbJw3ocl.fzAvgi6/Yrtgs3rtZl7EcsIhbDL2QUG", "ROLE_USER_2"));
//  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    users = usersFetchService.fetchAllUsers();
    Optional<JwtUserDetails> findFirst = jswUsersList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

//    JavacProcessingEnvironment

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


