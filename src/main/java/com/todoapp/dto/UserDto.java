package com.todoapp.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
//    private Long userId;
    private String userName;
    private String password;
}
