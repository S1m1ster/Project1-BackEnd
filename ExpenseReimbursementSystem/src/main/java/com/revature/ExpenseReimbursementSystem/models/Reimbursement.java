package com.revature.ExpenseReimbursementSystem.models;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="reimbursements")
public class Reimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reimbursement_id", nullable = false)
    private int reimbursementId;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "reimbursement_id", nullable = false)
    private int author;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "submitted_date", nullable = false)
    private Date submittedDate;

    @Column(name = "status_id", nullable = false)
    private int status;

    @Column(name = "type_id", nullable = false)
    private int type;

    @JoinColumn(name = "resolver_id",referencedColumnName = "reimbursement_id")
    private int resolver;

    @Column(name = "resolved_date")
    private Date resolvedDate;

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }
}
