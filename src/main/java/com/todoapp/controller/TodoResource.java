//package com.todoapp.controller;
//
//import com.todoapp.bean.Todo;
//import com.todoapp.service.TodoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//
//public class TodoResource {
//
//    @Autowired
//    TodoService todoService;
//
//    @GetMapping("/users/{username}/todos")
//    public List<Todo> getAllTodos(@PathVariable String username) {
//        return todoService.findAll();
//    }
//
//    @GetMapping("/users/{username}/todos/{id}")
//    public Todo retrieveTodo(@PathVariable String username, @PathVariable UUID id) {
//        return todoService.findById(id);
//    }
//
//    @DeleteMapping("/users/{username}/todos/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable long id) {
//
//        Todo todo = todoService.deleteById(id);
//        if(todo != null)
//            return ResponseEntity.noContent().build();
//
//        return ResponseEntity.noContent().build();
//
//    }
//
//    @PutMapping("/users/{username}/todos/{id}")
//    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
//                                           @RequestBody Todo todo) {
//        Todo todo1 = todoService.save(todo);
//
//        return new ResponseEntity<Todo>(todo1,HttpStatus.OK);
//    }
//
//    @PostMapping("/users/{username}/todos")
//    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
//        Todo todo1 = todoService.save(todo);
//        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(todo1.getId()).toUri();
//
//        return ResponseEntity.created(uri).build();
//    }
//
//}
