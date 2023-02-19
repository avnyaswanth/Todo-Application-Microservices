package com.todoapp.service.impl;

import com.todoapp.bean.Todos;
import com.todoapp.repository.TodoMongoRepo;
import com.todoapp.service.TodoMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoMongoServiceImpl implements TodoMongoService {

    @Autowired
    TodoMongoRepo todoMongoRepository;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Todos> findAll() {
        return todoMongoRepository.findAll();
    }

    public Todos deleteById(UUID id) {
        Todos todo = findById(id);
        if(todo != null)
            todoMongoRepository.deleteById(id);
        return null;
    }

    public Todos findById(UUID id) {
        Optional<Todos> todo = todoMongoRepository.findById(id);
        log.warn("findById - {}", todo);
        if(todo.isPresent())
            return todo.get();
        return null;
    }

    public Todos save(Todos todo) {
        return todoMongoRepository.save(todo);
    }

    public List<Todos> findByUsername(String username) {
        return todoMongoRepository.findByUsername(username);
    }
}
