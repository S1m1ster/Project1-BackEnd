package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin("*")
public class UserController {
    private UserService us;
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

    @GetMapping("/viewAccount")
    public ResponseEntity<Object> handleGetAccount(@RequestBody LinkedHashMap<String, String> body){
        try{
            int id = Integer.parseInt(body.get("id"));
            return new ResponseEntity<>(us.viewAccount(id), HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
