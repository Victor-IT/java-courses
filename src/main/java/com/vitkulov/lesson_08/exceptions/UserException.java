package com.vitkulov.lesson_08.exceptions;

public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
