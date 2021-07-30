package com.ozzy.springhibernateshort.exceptions;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String msn){
        super(msn);
    }
}
