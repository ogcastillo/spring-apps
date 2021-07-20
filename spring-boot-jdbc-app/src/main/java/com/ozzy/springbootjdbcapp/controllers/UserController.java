package com.ozzy.springbootjdbcapp.controllers;

import com.ozzy.springbootjdbcapp.dtos.UserDto;
import com.ozzy.springbootjdbcapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value= "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto saveUser(@RequestBody UserDto newUser, HttpServletRequest req){

        return userService.saveUser(newUser);

    }

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public List<UserDto> getAll(HttpServletResponse respond){

        return  userService.getAll();

    }

}
