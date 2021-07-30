package com.ozzy.springhibernateshort.dtos;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String designation;
    private int baseSalary;

    public UserDto(String firstName, String lastName, String address, String designation, int baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.designation = designation;
        this.baseSalary = baseSalary;
    }
}
