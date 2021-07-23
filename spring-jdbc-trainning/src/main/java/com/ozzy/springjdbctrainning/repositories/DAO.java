package com.ozzy.springjdbctrainning.repositories;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> listAll();

    int create (T t);

    Optional<T> read(int id);

    int update(T t);

    int delete(int id);

}
