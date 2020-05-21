package com.diego.ecommerce.handlers;

import com.diego.ecommerce.exception.HttpException;
import com.diego.ecommerce.exception.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<StandardError> httpException(HttpException e, HttpServletRequest request) {
        HttpStatus status = e.status;

        StandardError err = new StandardError(Instant.now(),
                status.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}