package com.revature.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "role")
    private Roles userPair_role;


    //Login user constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Update user constructor
    public User(String username, String password, String firstName, String lastName, String email){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + "\n" +
                ", password='" + password + "\n" +
                ", firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\n" +
                ", email='" + email + "\n" +
                ", userPair_role=" + userPair_role +
                '}';
    }
}
