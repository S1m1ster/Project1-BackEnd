package com.revature.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Column(name = "role_type", nullable = false, length = 120)
    private String roleType;

    @OneToOne(mappedBy = "userPair_role")
    private User user;
}
