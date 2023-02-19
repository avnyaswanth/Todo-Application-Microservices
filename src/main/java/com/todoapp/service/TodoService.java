package com.todoapp.service;


import com.todoapp.bean.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo deleteById(Long id);

    Todo findById(Long id);

    Todo save(Todo todo);

    List<Todo> findByUsername(String username);
}
