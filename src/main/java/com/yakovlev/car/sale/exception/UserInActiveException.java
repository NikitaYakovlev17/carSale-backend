package com.yakovlev.car.sale.exception;

public class UserInActiveException extends RuntimeException {
    public UserInActiveException(String message) {
        super(message);
    }
}