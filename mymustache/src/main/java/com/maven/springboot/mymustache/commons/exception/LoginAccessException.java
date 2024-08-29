package com.maven.springboot.mymustache.commons.exception;

public class LoginAccessException extends RuntimeException {
    public LoginAccessException(String message) {
        super(message);
    }
}
