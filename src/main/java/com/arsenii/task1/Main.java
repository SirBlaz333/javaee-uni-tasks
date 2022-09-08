package com.arsenii.task1;

public class Main {
    public static void main(String[] args) throws IncorrectSalaryException, FieldLengthLimitException {
        createEmployeeWithIncorrectSalary();
    }

    public static void createEmployeeWithIncorrectSalary() throws IncorrectSalaryException, FieldLengthLimitException {
        Employee employee = new Employee("John", "Jo", -20.0);
    }

    public static void createEmployeeWithTooLongFieldLength() throws IncorrectSalaryException, FieldLengthLimitException {
        Employee employee = new Employee("JohnJohnJohnJohnJohnJohn", "Jo", -20.0);
    }
}
