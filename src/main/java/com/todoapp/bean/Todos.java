package com.todoapp.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "todos")
public class Todos {

    @Id
    private UUID id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

}
