package com.ozzy.springhibernatetrainning.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class UserDto {
    private int id;
    private String username;
    private String password;
}
