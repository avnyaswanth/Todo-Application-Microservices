package com.todoapp.repository;


import com.todoapp.bean.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public
interface TodoMongoRepo extends MongoRepository<Todos, UUID> {
    List<Todos> findByUsername(String username);
}
