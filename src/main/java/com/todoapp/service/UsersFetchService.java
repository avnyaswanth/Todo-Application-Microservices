package com.todoapp.service;

import com.todoapp.dto.UserDto;

import java.util.List;

public interface UsersFetchService {
    List<UserDto> fetchAllUsers();
}
