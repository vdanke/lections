package org.step.fifth.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Position position;

    private int id;
    private int age;

    private List<Integer> integers = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName, int id, int age, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.id = id;
        this.age = age;
        integers.add(1);
        integers.add(2);
        integers.add(3);
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }
}
