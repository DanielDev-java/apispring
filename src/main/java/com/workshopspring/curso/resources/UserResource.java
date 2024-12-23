package com.workshopspring.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshopspring.curso.entities.User;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Daniel", "manodaniel4299@gmail.com", "88996237986", "125468979");

        return ResponseEntity.ok().body(u);
    }

}
