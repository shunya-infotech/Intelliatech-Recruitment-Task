package com.shunya.spring_samples.exception;

public class FileNotAnImageException extends RuntimeException{
    
    public FileNotAnImageException(String message){
        super(message);
    }
}
