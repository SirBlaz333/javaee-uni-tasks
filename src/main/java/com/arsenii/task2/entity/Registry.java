package com.arsenii.task2.entity;

import com.arsenii.task2.exception.EmployeeInRegistryException;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    public static final String EMPLOYEE_REGISTERED_MESSAGE = "Employee is already registered";
    private static Registry registry;
    private final List<Employee> employees;

    private Registry() {
        employees = new ArrayList<>();
    }

    public static Registry getInstance() {
        if (registry == null) {
            registry = new Registry();
        }
        return registry;
    }

    public void add(Employee employee) throws EmployeeInRegistryException {
        if (employees.contains(employee)) {
            throw new EmployeeInRegistryException(EMPLOYEE_REGISTERED_MESSAGE);
        }
        employees.add(employee);
    }

    public void printList() {
        System.out.println(employees);
    }
}
