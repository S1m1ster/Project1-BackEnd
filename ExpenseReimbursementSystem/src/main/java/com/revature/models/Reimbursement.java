package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="reimbursements")
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reimbursement_id", nullable = false)
    private int reimbursementId;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "author_id")
    private User userPair;


    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "submitted_date", nullable = false)
    private Date submittedDate;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "status_id")
    private Status reimbursement_status;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "type_id")
    private Type reimbursement_type;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resolver_id")
    private User userResolver_ticket;



    @Column(name = "resolved_date")
    private Date resolvedDate;

    //Creating a reimbursement ticket constructor
    public Reimbursement(User userPair_ticket, double amount, String description, Date submittedDate, Status reimbursement_status, Type reimbursement_type) {
        this.userPair = userPair_ticket;
        this.amount = amount;
        this.description = description;
        this.submittedDate = submittedDate;
        this.reimbursement_status = reimbursement_status;
        this.reimbursement_type = reimbursement_type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId + "\n" +
                ", userPair_ticket=" + userPair + "\n" +
                ", amount=" + amount + "\n" +
                ", description='" + description + "\n" +
                ", submittedDate=" + submittedDate + "\n" +
                ", reimbursement_status=" + reimbursement_status + "\n" +
                ", reimbursement_type=" + reimbursement_type + "\n" +
                ", userResolver_ticket=" + userResolver_ticket + "\n" +
                ", resolvedDate=" + resolvedDate +
                '}';
    }
}
