package com.exception;

public class TimedOutException extends RuntimeException{
    public TimedOutException() {
    }

    public TimedOutException(String message) {
        super(message);
    }
}
