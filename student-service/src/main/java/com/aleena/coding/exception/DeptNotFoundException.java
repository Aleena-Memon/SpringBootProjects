package com.aleena.coding.exception;

public class DeptNotFoundException extends RuntimeException{

    public DeptNotFoundException(String message) {
        super(message);
    }
}
