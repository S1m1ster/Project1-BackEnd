package com.revature.services;

import com.revature.models.Roles;
import com.revature.models.User;
//import com.revature.repo.ReimbursementRepo;
import com.revature.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepo ur;
    //private ReimbursementRepo rr;

    //, ReimbursementRepo rr
    @Autowired
    public UserService(UserRepo ur){
        this.ur = ur;
        //this.rr = rr;
    }


    public User loggedIn(String email, String password){
        User loggedIn = ur.findUserByEmailAndPassword(email, password);
        if(loggedIn == null){
            System.out.println("Account does not exist");
        }
        return loggedIn;
    }




}
