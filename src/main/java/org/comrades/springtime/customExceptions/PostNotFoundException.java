package org.comrades.springtime.customExceptions;

public class PostNotFoundException extends Exception{
    private String exceptionMessage;

    public PostNotFoundException(String message) {
        exceptionMessage = message;
    }

    public String getMessage() {
        return exceptionMessage;
    }
}
