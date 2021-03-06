package com.ozzy.springbootjdbcapp.services;

import com.ozzy.springbootjdbcapp.dtos.UserDto;
import com.ozzy.springbootjdbcapp.models.User;
import com.ozzy.springbootjdbcapp.dao.UserJdbcDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserJdbcDAO userJdbcDAO;

//    @Autowired
//    public UserService (UserJdbcDAO userJdbcDAO){
//        this.userJdbcDAO = userJdbcDAO;
//    }

    @Transactional
    public int saveUser (UserDto newUser){
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());

        return userJdbcDAO.create(user);

    }

    @Transactional(readOnly = true)
    public List<UserDto> getAll(){
        List<UserDto> usersDto = new ArrayList<UserDto>();
        List<User> users = userJdbcDAO.list();

        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setUserId(String.valueOf(user.getId()));
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            usersDto.add(userDto);
        });
        return usersDto;
    }


}
