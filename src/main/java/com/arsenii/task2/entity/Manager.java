package com.arsenii.task2.entity;

public class Manager extends Employee {
    private Double bonus;

    public Manager() {
    }

    public Manager(String name, String department, Double salary, Integer managerId, Double bonus) {
        super(name, department, salary, managerId);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", department='" + getDepartment() + '\'' +
                ", salary=" + getSalary() +
                ", managerId=" + getManagerId() +
                ", bonus=" + bonus +
                '}';
    }
}
