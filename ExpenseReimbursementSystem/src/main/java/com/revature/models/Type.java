package com.revature.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "reimbursement_type")
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false)
    private int typeId;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", type='" + type + "\n" +
                '}';
    }
}
