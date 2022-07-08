package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.repo.ReimbursementRepo;
import com.revature.repo.StatusRepo;
import com.revature.repo.TypeRepo;
import com.revature.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
@Transactional
public class ReimbursementService {
    private ReimbursementRepo rr;
    private UserRepo ur;
    private StatusRepo sr;
    private TypeRepo tr;

    @Autowired
    public ReimbursementService(ReimbursementRepo rr, UserRepo ur, StatusRepo sr, TypeRepo tr){
        this.rr = rr;
        this.ur = ur;
        this.sr = sr;
        this.tr = tr;
    }

    public Reimbursement createReimbursement(int userPair_ticket, double amount, String description, Date submittedDate, int reimbursement_status, int reimbursement_type){
        User currentUser = ur.findUserByUserId(userPair_ticket);
        Status currentStatus = sr.findStatusBystatusId(reimbursement_status);
        Type currentType = tr.findTypeBytypeId(reimbursement_type);
        Reimbursement ticket = new Reimbursement(currentUser, amount, description, submittedDate, currentStatus, currentType);
        return rr.save(ticket);
    }


}
