//package com.todoapp.controller;
//
//import com.todoapp.bean.Todo;
//import com.todoapp.jwt.JwtInMemoryUserDetailsService;
//import com.todoapp.service.UsersFetchService;
//import com.todoapp.service.impl.TodoJpaServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@Slf4j
//public class TodoJpaResource {
//
////    @Autowired
////    TodoService todoService;
//
//    @Autowired
//    TodoJpaServiceImpl todoJpaService;
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private UsersFetchService usersFetchService;
//
//    @Autowired
//    private JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService;
//
//    @GetMapping("/jpa/users/{username}/todos")
//    public List<Todo> getAllTodos(@PathVariable String username) {
//        List<Todo> todos = todoJpaService.findByUsername(username);
//        log.info("Todos called from react website : {}", todos);
//        return todos;
//    }
//
//    @GetMapping("/jpa/users/{username}/todos/{id}")
//    public Todo retrieveTodo(@PathVariable String username, @PathVariable Long id) {
////        Long id = Long.fromString(id);
//        log.warn("retrieve Todo method called with Long - {}", id);
//        return todoJpaService.findById(id);
//    }
//
//    @DeleteMapping("/jpa/users/{username}/todos/{id}")
//    public ResponseEntity<String> deleteById(@PathVariable String username, @PathVariable Long id) {
//        Todo todo = todoJpaService.deleteById(id);
//        if(todo == null)
//            return ResponseEntity.ok("Todo with id : " + id + "Can't be found");
//
//        return ResponseEntity.ok("Todo with id : " + id + "Successfully Deleted");
//
//    }
//
//    @PutMapping("/jpa/users/{username}/todos/{id}")
//    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long id,
//                                           @RequestBody Todo todo) {
//        todo.setUsername(username);
//        Todo updatedTodo = todoJpaService.save(todo);
//
//        return new ResponseEntity<Todo>(updatedTodo,HttpStatus.OK);
//    }
//
//    @PostMapping("/jpa/users/{username}/todos")
//    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
//        log.warn("Creating todo - {}", todo);
//
////        if(todo.getId())
//        todo.setUsername(username);
//        log.info("Todo-Long : {} and its class - {}", todo.getId(), todo.getId().getClass());
//        Todo todo1 = todoJpaService.save(todo);
////        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
////                .path("/{id}").buildAndExpand(todo1.getId()).toUri();
//
//        return ResponseEntity.ok().build();
//    }
//
////    @GetMapping("/jpa/users")
////    public void fetchAllUsers() {
////        List<UserDto> users = usersFetchService.fetchAllUsers();
////        jwtInMemoryUserDetailsService.setUsers(users);
////        List<JwtUserDetails> jswUsersList = new ArrayList<>();
////        users.forEach(user -> {
////            jswUsersList.add(new JwtUserDetails(user.getUserId(), user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassword()), "ROLE_USER_2"));
////        });
////        jwtInMemoryUserDetailsService.setJswUsersList(jswUsersList);
////    }
//
//}