package ru.mtsbank.exception;

import java.util.concurrent.ExecutionException;

public class CustomExecutionException extends ExecutionException {
    public CustomExecutionException() {
        super();
    }

    public CustomExecutionException(String message) {
        super(message);
    }
}