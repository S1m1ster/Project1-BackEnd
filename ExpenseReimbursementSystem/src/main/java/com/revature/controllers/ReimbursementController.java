package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ReimbursementController {

    private ReimbursementService rs;

    @Autowired
    public ReimbursementController(ReimbursementService rs){
        this.rs = rs;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> handleCreateReimbursement(@RequestBody LinkedHashMap<String, String> body){
        try{
            int userId = Integer.parseInt(body.get("id")), statusID = 1, typeId =Integer.parseInt(body.get("type"));
            Date createdDate = Date.valueOf(LocalDate.now());
            double amount = Double.parseDouble(body.get("amount"));

            Reimbursement ticket = rs.createReimbursement(userId, amount, body.get("description"), createdDate, statusID, typeId);
            System.out.println("ticket was created: ");
            return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to create ticket", HttpStatus.BAD_REQUEST);
        }
        
    }

    @GetMapping("/viewReimbursement/{id}/{type}")
    public ResponseEntity<Object> handleViewReimbursement(@PathVariable("id") int userId, @PathVariable("type")int type){
        try{
            return new ResponseEntity<>(rs.getEmployeeReimbursement(userId, type), HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed to find reimbursement",HttpStatus.BAD_REQUEST);
        }
    }
}
