package org.step.fifth;

import org.step.fifth.data.Data;
import org.step.fifth.data.domain.Employee;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) throws Exception {
//        create();
//        nonTerminateMethods();

        List<Employee> employees = Data.employees;

        List<Employee> collect = employees.stream().distinct().collect(Collectors.toList());
        long jack = collect.stream().filter(employee -> employee.getFirstName().equals("Jack")).count();

        System.out.println(jack);

//        List<Employee> employees = Data.employees;
//        List<Employee> collect = employees.stream()
//                .filter(employee -> employee.getAge() > 30)
//                .peek(employee -> {
//                    int age = employee.getAge();
//                    System.out.println(age);
//                })
//                .collect(Collectors.toList());
//        List<Employee> employees1 = Data.employees;
//        List<Employee> collect1 = employees.stream().limit(5).peek(System.out::println).collect(Collectors.toList());
    }

    public static void create() throws Exception {
        String str = "First string";
        List<Employee> employees = Data.employees;
        int[] integers = {1,2,3,4,5};
        Random random = new Random();

        // часто
        Stream<Employee> stream = employees.stream();
        Stream<? extends Number> stream2 = Stream.of(1, 1.1, 2.3);
        // часто
        IntStream stream1 = Arrays.stream(integers);
        // средне
        Stream<String> lines = Files.lines(Paths.get("material.txt"));
        //часто
        IntStream chars = str.chars();
        Stream<String> build = Stream.<String>builder()
                .add("first")
                .add("second")
                .build();
        Stream<Employee> employeeStream = employees.parallelStream();
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1);
        Stream<String> generate = Stream.generate(() -> "Next " + random.nextInt(1000));

        Employee employee1 = stream
                .filter(employee -> employee.getAge() < 30)
                .findFirst()
                .orElseThrow();

        System.out.println(employee1.getFirstName());
//        lines.forEach(System.out::println);
    }

    public static void nonTerminateMethods() {
        List<Employee> employees = Data.employees;

        Stream<Employee> stream = employees.stream();

        // часто
        Stream<Employee> employeeStream = stream.filter(employee -> employee.getAge() > 30);
        Stream<Employee> skip = stream.skip(5);
        // часто
        Stream<Employee> distinct = stream.distinct();
        // часто
        Stream<String> stringStream = stream.map(Employee::getFirstName);
        Stream<Employee> peek = stream.peek(System.out::println);
        Stream<Employee> limit = stream.limit(5);
        // часто
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));

        // flatMap - все элементы без стримов
        // часто
        IntStream intStream = stream.mapToInt(Employee::getAge);
        Stream<Integer> integerStream = stream.flatMap(employee -> employee.getIntegers().stream());
        Stream<Stream<Integer>> streamStream = stream.map(employee -> employee.getIntegers().stream());
    }
}
