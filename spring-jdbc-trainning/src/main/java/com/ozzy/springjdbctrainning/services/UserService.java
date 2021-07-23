package com.ozzy.springjdbctrainning.services;

import com.ozzy.springjdbctrainning.dtos.UserDto;
import com.ozzy.springjdbctrainning.models.User;
import com.ozzy.springjdbctrainning.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDto> getAll(){
        List<User> users = userRepository.listAll();
        List<UserDto> usersDto = new ArrayList<UserDto>();
        users.forEach(user -> {
            UserDto userDto = new UserDto(user.getId(),user.getUsername(), user.getPassword());
            usersDto.add(userDto);
        });
        return usersDto;
    }

    @Transactional(readOnly = true)
    public UserDto get(int id){
        Optional<User> user = userRepository.read(id);
        return user.map(value -> new UserDto(value.getId(), value.getUsername(), value.getPassword())).orElse(null);
    }

    @Transactional
    public int saveUser(UserDto newUser){
        User userToSave = new User();
        userToSave.setUsername(newUser.getUsername());
        userToSave.setPassword(newUser.getPassword());
        return userRepository.create(userToSave);
    }

    @Transactional
    public int updateUser(UserDto user){
        User userToUpdate = new User();
        userToUpdate.setId(user.getId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.update(userToUpdate);
    }

    @Transactional
    public int deleteUser(int userId){
        return userRepository.delete(userId);
    }

}
