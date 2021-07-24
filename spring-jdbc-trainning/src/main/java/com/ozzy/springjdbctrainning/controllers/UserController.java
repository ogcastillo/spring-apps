package com.ozzy.springjdbctrainning.controllers;

import com.ozzy.springjdbctrainning.dtos.UserDto;
import com.ozzy.springjdbctrainning.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserController {
    private final UserService userService;


    @GetMapping(value ="/getAll", produces = APPLICATION_JSON_VALUE)
    public List<UserDto> getAll(HttpServletResponse res){
        List<UserDto> usersDto = userService.getAll();
        if (usersDto.size() > 0){
            res.setStatus(200);
            return usersDto;
        }else{
            res.setStatus(404);
            return null;
        }
    }

    @GetMapping(value = "/get",produces = APPLICATION_JSON_VALUE)
    public UserDto getUser(@RequestParam int user_Id, HttpServletRequest req, HttpServletResponse res){
        return userService.get(user_Id);
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody UserDto newUser, HttpServletRequest req, HttpServletResponse res){
        int rows = userService.saveUser(newUser);
        if (rows > 0){
            res.setStatus(201);
        }else{
            res.setStatus(409);
        }
    }

    @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody UserDto user, HttpServletRequest req, HttpServletResponse res){
            int result = userService.updateUser(user);
            if (result > 0){
                res.setStatus(200);
            }else{
                res.setStatus(404);
            }
    }

    @DeleteMapping(value = "/delete")
    public void deleteUser(@RequestParam int user_Id, HttpServletRequest req, HttpServletResponse res){
        int result= userService.deleteUser(user_Id);
        if(result > 0){
            res.setStatus(200);
        }else{
            res.setStatus(404);
        }
    }

}
