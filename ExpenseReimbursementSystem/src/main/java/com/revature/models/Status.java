package com.revature.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reimbursement_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id", nullable = false)
    private int statusID;

    @Column(name = "status", nullable = false, length = 40)
    private String status;


}
