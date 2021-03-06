package com.weather.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3332292346834265371L;

    public DataNotFoundException(String zipcode){
        super("DataNotFoundException with zipcode="+zipcode);
    }
}