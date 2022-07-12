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

    @GetMapping("/viewReimbursement")
    public ResponseEntity<Object> handleViewReimbursement(@RequestBody LinkedHashMap<String, String> body){
        try{
            int userId = Integer.parseInt(body.get("id"));
            int type = Integer.parseInt(body.get("type"));
            ArrayList<Reimbursement> ticket = rs.getEmployeeReimbursement(userId, type);
            if(ticket.isEmpty()){
                return new ResponseEntity<>("You currently don't have any reimbursement tickets", HttpStatus.NO_CONTENT);
            }
            else{
                if(type >0 && type < 3){
                    return new ResponseEntity<>(ticket, HttpStatus.FOUND);
                }
                return new ResponseEntity<>("status type invalid", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed to find reimbursement",HttpStatus.BAD_REQUEST);
        }
    }
}
