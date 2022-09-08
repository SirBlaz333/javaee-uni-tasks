package com.arsenii.task1;

public class Employee {
    private static final Integer MAX_LENGTH = 20;
    private static final String FIELD_LIMIT_MESSAGE = "Field length is too long";
    private static Integer nextId = 1;
    private final Integer id;
    private String name;
    private String surname;
    private Double salary;

    public Employee(String name, String surname, Double salary) throws FieldLengthLimitException {
        this.id = nextId++;
        this.salary = salary;
        setName(name);
        setSurname(surname);
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

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private void validateFieldLength(String field) throws FieldLengthLimitException {
        if (field.length() > MAX_LENGTH) {
            throw new FieldLengthLimitException(FIELD_LIMIT_MESSAGE);
        }
    }
}
