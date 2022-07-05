package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin("*")
public class UserController {
    private UserService us;
    private User newEmployee;
    @Autowired
    public UserController(UserService us){
        this.us = us;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> handleLogin(@RequestBody LinkedHashMap<String, String> body){
        String email = body.get("email"), password = body.get("password");
        User u = us.loggedIn(email, password);
        if(u != null){
            return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>("Invalid email or password", HttpStatus.NOT_ACCEPTABLE);
        }

    }


}
