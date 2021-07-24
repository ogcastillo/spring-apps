package com.ozzy.springjdbctrainning.aspect;


import com.ozzy.springjdbctrainning.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingAspect {

//    @ExceptionHandler(InvalidRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public void handleInvalidRequestException() {}
//
//    @ExceptionHandler(InvalidCredentialsException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public void handleInvalidCredentialsException() {}
//
//    @ExceptionHandler(DuplicateRegistrationException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public void handleDuplicateRegistrationException() {}

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDataNotFoundException() {}
}
