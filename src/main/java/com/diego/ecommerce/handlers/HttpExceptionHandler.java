package com.diego.ecommerce.handlers;

import com.diego.ecommerce.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity
            <HttpException> httpException(HttpException e, HttpServletRequest request) {
        HttpStatus status = e.status;
        return ResponseEntity.status(status).body(e);
    }
}