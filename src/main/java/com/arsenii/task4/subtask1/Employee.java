package com.arsenii.task4.subtask1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee {
    private final String name;
    private final String department;
    private final Integer salary;
    private final List<Employee> subordinates;

    public Employee(String name, String department, Integer salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return new ArrayList<>(subordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name: '" + name + '\'' +
                ", department: '" + department + '\'' +
                ", salary: " + salary +
                ", subordinates: " +
                toStringSubordinates() +
                "} ";
    }

    private String toStringSubordinates(){
        if(subordinates.isEmpty()){
            return "none";
        }
        return subordinates.stream().
                map(Employee::toString).
                collect(Collectors.joining());
    }
}
