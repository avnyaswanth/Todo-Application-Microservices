package com.todoapp.bean;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

}
