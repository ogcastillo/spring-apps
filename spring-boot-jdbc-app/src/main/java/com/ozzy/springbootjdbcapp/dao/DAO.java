package com.ozzy.springbootjdbcapp.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();

    T create (T t);

    Optional<T> get(int id);

    boolean update(T t, String[] params);

    boolean delete(T t);
}
