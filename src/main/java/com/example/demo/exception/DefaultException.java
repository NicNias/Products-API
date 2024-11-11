package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class DefaultException  {
    private String message;
    private int status;

    public DefaultException(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
