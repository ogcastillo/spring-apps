package com.ozzy.springhibernateshort.controllers;

import com.ozzy.springhibernateshort.dtos.UserDto;
import com.ozzy.springhibernateshort.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserController{
    private final UserService userService;

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody UserDto userDto, HttpServletRequest req, HttpServletResponse res){
        userService.saveUser(userDto);
    }

    @GetMapping(value = "/get",produces = APPLICATION_JSON_VALUE)
    public UserDto getUser(@RequestParam int id, HttpServletRequest req, HttpServletResponse res){
        return userService.getUser(id);
    }

}
