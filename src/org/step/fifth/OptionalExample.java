package org.step.fifth;

import org.step.fifth.data.Data;
import org.step.fifth.data.domain.Employee;
import org.step.fifth.data.domain.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OptionalExample {

    private static Map<Integer, String> integerStringMap = new HashMap<>();

    static {
        integerStringMap.put(1, "first");
        integerStringMap.put(2, "Second");
        integerStringMap.put(3, "Third");
    }

    public static void main(String[] args) {
        Employee employee = new Employee(
                "Joe", "John", 5432, 28, Position.WORKER);

        Optional<Employee> optionalOfEmployee = Optional.of(employee);

        if (optionalOfEmployee.isPresent()) {
            Employee employee1 = optionalOfEmployee.get();
        } else {
            throw new RuntimeException("Ssory can't find the worker");
        }

        optionalOfEmployee.ifPresent(employee1 -> {
            Employee employee2 = optionalOfEmployee.get();
            System.out.println(employee2.getAge());
        });

        Integer integer = optionalOfEmployee.map(employee1 -> employee.getAge()).orElseThrow();
        System.out.println(integer);
    }

    public static Employee saveWorker(String name, String surname, int id, int age) {
        Optional<Employee> employee = getEmployee(id);

        return employee.orElse(new Employee(name, surname, id, age, Position.WORKER));
    }

    public static Optional<Employee> getEmployee(long id) {
        List<Employee> employees = Data.employees;

        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();

//        return Optional.ofNullable(employees.stream().filter(employee -> {
//            return employee.getId() == id;
//        }).findFirst().get());
    }

    public static Employee getEmployeeOrElseThrowException(long id) {
        List<Employee> employees = Data.employees;

        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public static Optional<String> getFromMap(int key) {
        return Optional.ofNullable(integerStringMap.get(key));
    }
}