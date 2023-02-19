//package com.todoapp.service.impl;
//
//import com.todoapp.bean.Todo;
//import com.todoapp.service.TodoService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@Qualifier("Todoservice")
//public class TodoServiceImpl implements TodoService {
//    private static List<Todo> todos = new ArrayList<>();
//    private static UUID id;
//
////    static {
////        todos.add(new Todo(++id, "hacker", "Learn spring boot", new Date(), false));
////        todos.add(new Todo(++id, "hacker", "Learn Java", new Date(), false));
////        todos.add(new Todo(++id, "hacker", "Learn react", new Date(), false));
////    }
//
//    @Override
//    public List<Todo> findAll() {
//        return todos;
//    }
//
//    @Override
//    public Todo deleteById(UUID id) {
//        Todo todo = findById(id);
//        todos.remove(todo);
//        return todo;
//    }
//
//    @Override
//    public Todo findById(UUID id) {
//        for(Todo todo : todos) {
//            if(todo.getId() == id)
//                return todo;
//        }
//        return null;
//    }
//
////    @Override
////    public Todo save(Todo todo) {
////        if (todo.getId() == -1 || todo.getId() == 0)
////            todo.setId(++id);
////        else
////            deleteById(todo.getId());
////        todos.add(todo);
////        return todo;
////    }
//}
