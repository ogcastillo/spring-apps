package com.ozzy.springbootjdbcapp.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String userId;
    private String username;
    private String password;

}
