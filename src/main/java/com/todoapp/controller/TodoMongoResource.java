package com.todoapp.controller;

import com.todoapp.bean.Todos;
import com.todoapp.jwt.JwtInMemoryUserDetailsService;
import com.todoapp.service.TodoMongoService;
import com.todoapp.service.UsersFetchService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class TodoMongoResource {


    @Autowired
    TodoMongoService todoMongoService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsersFetchService usersFetchService;

    @Autowired
    private JwtInMemoryUserDetailsService jwtInMemoryUserDetailsService;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todos> getAllTodos(@PathVariable String username) {
        List<Todos> todos = todoMongoService.findByUsername(username);
        log.info("Todoss called from react website : {}", todos);
        return todos;
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todos retrieveTodos(@PathVariable String username, @PathVariable UUID id) {
//        UUID id = UUID.fromString(id);
        log.warn("retrieve Todos method called with UUID - {}", id);
        return todoMongoService.findById(id);
    }

    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String username, @PathVariable UUID id) {
        Todos todo = todoMongoService.deleteById(id);
        if(todo == null)
            return ResponseEntity.ok("Todos with id : " + id + "Can't be found");

        return ResponseEntity.ok("Todos with id : " + id + "Successfully Deleted");

    }

    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todos> updateTodos(@PathVariable String username, @PathVariable UUID id,
                                           @RequestBody Todos todo) {
        todo.setUsername(username);
        Todos updatedTodos = todoMongoService.save(todo);

        return new ResponseEntity<Todos>(updatedTodos,HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodos(@PathVariable String username, @RequestBody Todos todo) {
        log.warn("Creating todo - {}", todo);

//        if(todo.getId())
        todo.setUsername(username);
        log.info("Todos-UUID : {} and its class - {}", todo.getId(), todo.getId().getClass());
        Todos todo1 = todoMongoService.save(todo);
//        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(todo1.getId()).toUri();

        return ResponseEntity.ok().build();
    }

//    @GetMapping("/jpa/users")
//    public void fetchAllUsers() {
//        List<UserDto> users = usersFetchService.fetchAllUsers();
//        jwtInMemoryUserDetailsService.setUsers(users);
//        List<JwtUserDetails> jswUsersList = new ArrayList<>();
//        users.forEach(user -> {
//            jswUsersList.add(new JwtUserDetails(user.getUserId(), user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassword()), "ROLE_USER_2"));
//        });
//        jwtInMemoryUserDetailsService.setJswUsersList(jswUsersList);
//    }

}