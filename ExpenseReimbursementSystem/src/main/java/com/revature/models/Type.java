package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_id", nullable = false)
    private int typeId;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @OneToOne(mappedBy = "reimbursement_type")
    private Reimbursement ticket;
}
