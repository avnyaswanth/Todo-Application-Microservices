package com.todoapp.test;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for(int i=0;i<10;++i)
        {
            String pass = bCryptPasswordEncoder.encode("alpha");
            System.out.println(pass);
        }
    }
}
