package com.crud.employemanagement.Exceptions;

public class RessourceNotFound extends RuntimeException{
    public RessourceNotFound(String message){
        super(message);
    }
}
