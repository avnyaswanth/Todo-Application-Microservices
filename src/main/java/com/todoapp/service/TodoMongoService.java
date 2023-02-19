package com.todoapp.service;

import com.todoapp.bean.Todos;

import java.util.List;
import java.util.UUID;

public interface TodoMongoService {
    List<Todos> findAll();
    Todos deleteById(UUID id);

    Todos findById(UUID id);

    Todos save(Todos todo);

    List<Todos> findByUsername(String username);
}
