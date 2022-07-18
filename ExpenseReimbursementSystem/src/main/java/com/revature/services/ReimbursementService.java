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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Reimbursement> getEmployeeReimbursement(int userID, int type){
        User currentUser = ur.findUserByUserId(userID);

        Reimbursement[] ticket = rr.findReimbursementByuserPair(currentUser);
        List<Reimbursement> ticketType = new ArrayList<>();

        for(int i =0; i < ticket.length; i++){
            if(type == 1){
                if(ticket[i].getReimbursement_status().getStatusId() == type){
                    ticketType.add(ticket[i]);
                }
            }
            else{
                if(ticket[i].getReimbursement_status().getStatusId() != 1){
                    ticketType.add(ticket[i]);
                }
            }
        }

        return ticketType;
    }
    public List<Reimbursement> getAllReimbursements(int type){
        List<Reimbursement> ticket = rr.findAll();
        List<Reimbursement> ticketType = new ArrayList<>();

        for(int i =0; i < ticket.size(); i++){
            if(type == 1){
                if(ticket.get(i).getReimbursement_status().getStatusId() == type){
                    ticketType.add(ticket.get(i));
                }
            }
            else{
                if(ticket.get(i).getReimbursement_status().getStatusId() != 1){
                    ticketType.add(ticket.get(i));
                }
            }
        }

        return ticketType;
    }

    public List<Reimbursement> getAllReimbursementsOfEmployee(int id){
        User searchedUser = ur.findById(id).get();
        List<Reimbursement> tickets = Arrays.asList(rr.findReimbursementByuserPair(searchedUser));

        return tickets;
    }

    public Reimbursement aprroveDenyReimbursement(int id, int status, int managerId){
        User manager = ur.findById(managerId).get();
        Reimbursement ticket = rr.findById(id).get();
        Status apprvDeny = sr.findById(status).get();
        Date dateResolved = Date.valueOf(LocalDate.now());

        ticket.setReimbursement_status(apprvDeny);
        ticket.setUserResolver_ticket(manager);
        ticket.setResolvedDate(dateResolved);

        return ticket;

    }


}
