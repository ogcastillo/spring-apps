package com.ozzy.springhibernatetrainning.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
