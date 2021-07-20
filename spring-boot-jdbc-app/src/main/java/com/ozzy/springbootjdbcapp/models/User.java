package com.ozzy.springbootjdbcapp.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String username;
    private String password;
}
