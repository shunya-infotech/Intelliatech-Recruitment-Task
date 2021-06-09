package com.shunya.spring_samples.exception;

public class EntityNotFoundException extends RuntimeException{
    
    public EntityNotFoundException(String message){
        super(message);
    }
}
