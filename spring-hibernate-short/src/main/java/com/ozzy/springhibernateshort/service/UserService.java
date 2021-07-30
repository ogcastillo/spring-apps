package com.ozzy.springhibernateshort.service;

import com.ozzy.springhibernateshort.dtos.UserDto;
import com.ozzy.springhibernateshort.exceptions.DataNotFoundException;
import com.ozzy.springhibernateshort.models.User;
import com.ozzy.springhibernateshort.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepo userRepo;

    public void saveUser(UserDto userDto){
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getAddress(), userDto.getDesignation(), userDto.getBaseSalary());
        userRepo.save(user);
    }

    public UserDto getUser(int id){
        Optional<User> user = userRepo.getUserById(id);
        if(user.isPresent()){
            return new UserDto(user.get().getId(), user.get().getFirstName(), user.get().getLastName(), user.get().getAddress(), user.get().getDesignation(), user.get().getBaseSalary());
        }else{
            throw new DataNotFoundException("User not found");
        }
    }



}
