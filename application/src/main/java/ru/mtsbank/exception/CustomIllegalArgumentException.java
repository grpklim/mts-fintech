package ru.mtsbank.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException{
    public CustomIllegalArgumentException() {
        super();
    }

    public CustomIllegalArgumentException(String s) {
        super(s);
    }
}