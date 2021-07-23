package com.ozzy.springjdbctrainning.repositories;

import com.ozzy.springjdbctrainning.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements DAO<User>{
    private final JdbcTemplate jdbcTemplate;

RowMapper<User> rowMapper = (rs,rowNum) ->{
    User user = new User();
    user.setId(rs.getInt("user_id"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    return user;
};

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> listAll() {
        String sql= "select user_id, username, password from users";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int create(User user) {
        String sql = "insert into users (username, password) values (?,?)";
        return jdbcTemplate.update(sql,user.getUsername(), user.getPassword());
    }

    @Override
    public Optional<User> read(int id) {
        String sql = "select user_id, username, password from users where user_id=?";
        User user = null;
        try{
            user = jdbcTemplate.queryForObject(sql,rowMapper, id);
        }catch (DataAccessException e){
            System.out.println("User not found");
        }
        return Optional.ofNullable(user);
    }

    @Override
    public int update(User user) {
        String sql = "update users set username=?, password=? where user_id=?";
        return jdbcTemplate.update(sql,user.getUsername(), user.getPassword(),user.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from users where user_id=?";
        return jdbcTemplate.update(sql,id);
    }
}
