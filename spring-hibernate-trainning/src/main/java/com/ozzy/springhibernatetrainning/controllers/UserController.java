package com.ozzy.springhibernatetrainning.controllers;

import com.ozzy.springhibernatetrainning.dtos.UserDto;
import com.ozzy.springhibernatetrainning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody UserDto userDto, HttpServletRequest req, HttpServletResponse res){
        userService.createUser(userDto);
    }

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    public UserDto getUserById(@RequestParam int id, HttpServletRequest req, HttpServletResponse res){
        return userService.findUserById(id);
    }


}
