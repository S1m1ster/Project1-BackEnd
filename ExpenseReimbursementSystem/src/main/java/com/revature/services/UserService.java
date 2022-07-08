package com.revature.services;

import com.revature.models.User;
import com.revature.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepo ur;
    private ReimbursementService rs;

    @Autowired
    public UserService(UserRepo ur, ReimbursementService rs){
        this.ur = ur;
        this.rs = rs;
    }


    public User loggedIn(String email, String password){
        User loggedIn = ur.findUserByEmailAndPassword(email, password);
        if(loggedIn == null){
            System.out.println("Account does not exist");
        }
        return loggedIn;
    }

    public User viewAccount(int id){
        User currentUser = ur.findById(id).get();
        return currentUser;
    }




}
