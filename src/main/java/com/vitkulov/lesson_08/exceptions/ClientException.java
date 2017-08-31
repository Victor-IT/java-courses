package com.vitkulov.lesson_08.exceptions;

public class ClientException extends UserException {
    public ClientException(String message) {
        super(message);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }
}
