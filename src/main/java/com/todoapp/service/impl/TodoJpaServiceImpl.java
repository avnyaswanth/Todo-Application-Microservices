//package com.todoapp.service.impl;
//
//import com.todoapp.bean.Todo;
//import com.todoapp.repository.TodoJpaRepository;
//import com.todoapp.repository.TodoMongoRepository;
//import com.todoapp.service.TodoJpaService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.lang.Long;
//
//@Service
//public class TodoJpaServiceImpl implements TodoJpaService {
//
//    @Autowired
//    TodoJpaRepository todoJpaRepository;
//    @Autowired
//    TodoMongoRepository todoMongoRepository;
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    public List<Todo> findAll() {
//        return todoJpaRepository.findAll();
//    }
//
//    public Todo deleteById(Long id) {
//        Todo todo = findById(id);
//        if(todo != null)
//            todoJpaRepository.deleteById(id);
//        return null;
//    }
//
//    public Todo findById(Long id) {
//        Optional<Todo> todo = todoJpaRepository.findById(id);
//        log.warn("findById - {}", todo);
//        if(todo.isPresent())
//            return todo.get();
//        return null;
//    }
//
//    public Todo save(Todo todo) {
//        return todoJpaRepository.save(todo);
//    }
//
//    public List<Todo> findByUsername(String username) {
//        return todoJpaRepository.findByUsername(username);
//    }
//}
