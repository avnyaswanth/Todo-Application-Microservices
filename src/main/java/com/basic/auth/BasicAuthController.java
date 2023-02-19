package com.basic.auth;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")

public class BasicAuthController {

    @GetMapping("/basicauth")
    public AuthBean getAuthBean() {
        return new AuthBean("Auth Bean");
    }

}
