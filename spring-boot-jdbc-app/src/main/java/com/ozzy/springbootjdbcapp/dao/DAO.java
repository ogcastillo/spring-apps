package com.ozzy.springbootjdbcapp.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();

    int create (T t);

    Optional<T> get(int id);

    int update(T t, String[] params);

    int delete(T t);
}
