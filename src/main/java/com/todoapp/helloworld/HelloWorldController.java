package com.todoapp.helloworld;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean getBeanWithPathVariable(@PathVariable String name) {
//        throw new RuntimeException("Something went wrong");
        return new HelloWorldBean("Hello " + name);
    }
}
