package com.exception;

public class OverMaxActiveException extends RuntimeException {
    public OverMaxActiveException(String message) {
        super(message);
    }

    public OverMaxActiveException() {
    }
}
