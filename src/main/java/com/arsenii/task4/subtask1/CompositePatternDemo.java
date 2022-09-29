package com.arsenii.task4.subtask1;

public class CompositePatternDemo {

    public static void main(String[] args) {
        Employee head = new Employee("John", "Human Resources", 15000);
        Employee hr = new Employee("Josh", "Human Resources", 10000);
        Employee programmer1 = new Employee("Jonathan", "Software Engineering", 12000);
        Employee programmer2 = new Employee("Joshua", "Software Engineering", 12500);
        head.addSubordinate(hr);
        hr.addSubordinate(programmer1);
        hr.addSubordinate(programmer2);
        System.out.println(head);
        System.out.println(hr);
        System.out.println(programmer1);
    }

}
