package com.ozzy.springbootjdbcapp.dao;

import com.ozzy.springbootjdbcapp.models.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class UserJdbcDAO implements DAO<User> {

    private final JdbcTemplate jdbcTemplate;

    RowMapper<User> userRowMapper = (rs,rowNum)->{
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    };

    @Autowired
    public UserJdbcDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> list() {
        String sql = "SELECT user_id, username, password FROM users";
        return jdbcTemplate.query(sql,userRowMapper);
    }

    @Override
    public User create(User user) {
     return null;
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(User user, String[] params) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
