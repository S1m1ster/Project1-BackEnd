package com.revature.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "username", nullable = false, length = 60)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "firstName", nullable = false, length = 60)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 60)
    private String lastName;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "role")
    private Roles userPair_role;

    public User(int userPair, Roles pairedRole){
        this.userId = userPair;
        this.userPair_role = pairedRole;
        this.userPair_role.setUser(this);
    }

    // User who create ticket
    @OneToMany(mappedBy = "userPair_ticket")
    private Set<Reimbursement> view = new HashSet<>();

    // User who resolves ticket
    @OneToMany(mappedBy = "userResolver_ticket")
    private Set<Reimbursement> edit = new HashSet<>();


}
