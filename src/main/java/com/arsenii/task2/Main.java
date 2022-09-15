package com.arsenii.task2;

import com.arsenii.task2.entity.Employee;
import com.arsenii.task2.entity.Manager;
import com.arsenii.task2.entity.Registry;
import com.arsenii.task2.exception.EmployeeInRegistryException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws EmployeeInRegistryException {
        List<Employee> employees = getEmployees();
        Employee duplicateEmployee = new Employee("Claudia", "Software Engineering", 900.0, 1);
        Registry registry = Registry.getInstance();
        for(Employee employee : employees){
            registry.add(employee);
        }
        registry.add(duplicateEmployee);
        registry.printList();
        registry.add(duplicateEmployee);
    }

    private static List<Employee> getEmployees(){
        return List.of(new Manager("Max", "Human Resources", 1000.0, null, 200.0),
                new Manager("Steve", "Human Resources", 700.0, 0, 100.0),
                new Employee("John", "Software Engineering", 1200.0, 0),
                new Employee("Jack", "Software Engineering", 800.0, 1));
    }
}
