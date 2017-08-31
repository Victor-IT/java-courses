package com.vitkulov.lesson_08.exceptions;

public class PetException extends UserException {

    public PetException(String message) {
        super(message);
    }

    public PetException(Throwable cause) {
        super(cause);
    }
}
