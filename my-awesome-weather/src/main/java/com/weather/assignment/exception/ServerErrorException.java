package com.weather.assignment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Something went wrong") //404
public class ServerErrorException extends Exception {

    private static final long serialVersionUID = -3332292346834265371L;

    public ServerErrorException(String zipcode){
        super("Something went wrong, with zipcode="+zipcode);
    }
}