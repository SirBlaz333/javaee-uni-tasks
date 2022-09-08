package com.arsenii.task1;

public class IncorrectSalaryException extends Exception {
    public IncorrectSalaryException() {
    }

    public IncorrectSalaryException(String message) {
        super(message);
    }
}
