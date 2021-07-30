package com.ozzy.springhibernateshort.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "designation")
    private String designation;

    @Column(name = "base_salary")
    private int baseSalary;

    public User(String firstName, String lastName, String address, String designation, int baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.designation = designation;
        this.baseSalary = baseSalary;
    }
}
