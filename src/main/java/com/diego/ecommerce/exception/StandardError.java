package com.diego.ecommerce.exception;


import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }
}