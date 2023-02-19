package com.todoapp.service.impl;

import com.todoapp.dto.UserDto;
import com.todoapp.service.UsersFetchService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserFetchServiceImpl implements UsersFetchService {

    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String URL = "http://localhost:8081/users";

    @Override
    public List<UserDto> fetchAllUsers() {
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<UserDto>> responseEntity = null;
        responseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<UserDto>>(){});
        List<UserDto> users = responseEntity.getBody();
//        users.forEach(user -> {
//            logger.info("User - {} : {}", user.getUserId(), user);
//        });
        return users;

    }
}
