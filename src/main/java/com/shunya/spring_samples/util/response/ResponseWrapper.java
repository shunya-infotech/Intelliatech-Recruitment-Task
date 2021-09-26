package com.shunya.spring_samples.util.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseWrapper<T extends Object> {
    
    private T result;
    private ResponseStatus status;
    private String message;
    private String type;

    public void setResponseSuccess(T result, String message, String type){

        this.result = result;
        this.status = ResponseStatus.SUCCESS;
        this.message = message;
        this.type = type;
    }
    
    public void setResponseFail(T result, String message, String type){

        this.result = result;
        this.status = ResponseStatus.FAIL;
        this.message = message;
        this.type = type;
    }

    public void setResponseException(T result, String message, String type){

        this.result = result;
        this.status = ResponseStatus.EXCEPTION;
        this.message = message;
        this.type = type;
    }
}
