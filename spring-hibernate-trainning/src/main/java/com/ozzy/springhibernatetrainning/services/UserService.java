package com.ozzy.springhibernatetrainning.services;

import com.ozzy.springhibernatetrainning.dtos.UserDto;
import com.ozzy.springhibernatetrainning.exceptions.DataNotFoundException;
import com.ozzy.springhibernatetrainning.models.User;
import com.ozzy.springhibernatetrainning.respositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto){
        User user = new User(userDto.getUsername(), userDto.getPassword());
        userRepository.save(user);
    }

    public UserDto findUserById(int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return new UserDto(user.get().getId(), user.get().getUsername(), user.get().getPassword());
        }else{
            throw new DataNotFoundException("User not found!!!");
        }
    }

    public UserDto findUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return new UserDto(user.get().getId(), user.get().getUsername(), user.get().getPassword());
        }else{
            throw new DataNotFoundException("User not found!!!");
        }

    }

}
