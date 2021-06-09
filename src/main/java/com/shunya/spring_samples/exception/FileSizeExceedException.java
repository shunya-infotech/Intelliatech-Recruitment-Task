package com.shunya.spring_samples.exception;

public class FileSizeExceedException extends RuntimeException{

    public FileSizeExceedException(String message){
        super(message);
    }    
}
