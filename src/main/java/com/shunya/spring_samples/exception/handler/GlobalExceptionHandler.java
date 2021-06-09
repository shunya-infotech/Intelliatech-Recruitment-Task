package com.shunya.spring_samples.exception.handler;

import com.shunya.spring_samples.exception.EntityNotFoundException;
import com.shunya.spring_samples.util.response.ResponseWrapper;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private final ResponseWrapper<?> exceptionResponse;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(Exception exception, WebRequest webRequest){

        log.error("exception at : " + webRequest.getDescription(false));
        setExceptionResponse(exception, webRequest);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception, WebRequest webRequest) {

        log.error("exception at : " + webRequest.getDescription(false));
        setExceptionResponse(exception, webRequest);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    public void setExceptionResponse(Exception exception, WebRequest webRequest){
        
        exceptionResponse.setResponseException(null,
                exception.getMessage() + ", Exception at " + webRequest.getDescription(false),
                exception.getClass().getSimpleName());
    }
}
