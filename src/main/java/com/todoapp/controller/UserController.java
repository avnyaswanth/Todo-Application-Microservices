//package com.todoapp.controller;
//
//import com.todoapp.bean.User;
//import com.todoapp.inter.School;
//import com.todoapp.repository.UserJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//
//public class UserController {
//
////    @Autowired
////    private UserJpaRepository userJpaRepository;
//
////    @Autowired
////    @Qualifier("college")
////    School school;
////
////    @GetMapping("/school")
////    public void getSchool() {
////        school.getStudentDetails();
////        System.out.println(school.getMp());
////    }
//
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userJpaRepository.findAll();
//    }
//
//    @PostMapping("/users/adduser")
//    public User addUser(@RequestBody User user) {
//        return userJpaRepository.save(user);
//    }
//
//}
