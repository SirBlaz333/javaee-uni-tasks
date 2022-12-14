package com.arsenii.task1;

public class Employee {
    private static final Integer MAX_LENGTH = 20;
    private static final String FIELD_LIMIT_MESSAGE = "Field length is too long";
    private static final int MIN_SALARY = 0;
    private static final String INCORRECT_SALARY_MESSAGE = "Salary cannot be negative number";
    private static Integer nextId = 1;
    private final Integer id;
    private String name;
    private String surname;
    private Double salary;

    public Employee() {
        this.id = nextId++;
    }

    public Employee(String name, String surname, Double salary) throws FieldLengthLimitException, IncorrectSalaryException {
        this.id = nextId++;
        setName(name);
        setSurname(surname);
        setSalary(salary);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setName(String name) throws FieldLengthLimitException {
        validateFieldLength(name);
        this.name = name;
    }

    public void setSurname(String surname) throws FieldLengthLimitException {
        validateFieldLength(surname);
        this.surname = surname;
    }

    public void setSalary(Double salary) throws IncorrectSalaryException {
        if (salary < MIN_SALARY) {
            throw new IncorrectSalaryException(INCORRECT_SALARY_MESSAGE);
        }
        this.salary = salary;
    }

    private void validateFieldLength(String field) throws FieldLengthLimitException {
        if (field.length() > MAX_LENGTH) {
            throw new FieldLengthLimitException(FIELD_LIMIT_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
