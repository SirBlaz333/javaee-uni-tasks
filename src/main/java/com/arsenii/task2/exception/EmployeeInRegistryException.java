package com.arsenii.task2.exception;

public class EmployeeInRegistryException extends Exception {
    public EmployeeInRegistryException() {
    }

    public EmployeeInRegistryException(String message) {
        super(message);
    }
}
