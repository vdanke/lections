package org.step.fifth;

import org.step.fifth.data.Data;
import org.step.fifth.data.domain.Employee;
import org.step.fifth.data.domain.Position;

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

        terminatedMethodsStreamObject();
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

    public static void terminatedMethodsStreamObject() {
        List<Employee> employees = Data.employees;

        Optional<Employee> first = employees.stream()
                .findFirst();
        Optional<Employee> any = employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .findAny();
        Map<Integer, String> collect = employees.stream()
                .collect(Collectors.toMap(
                            Employee::getId,
                            Employee::getFirstName
                        )
                );
        String collect1 = employees.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.joining("/"));
        long count = employees.stream().count();
        boolean isChef = employees.stream()
                .anyMatch(employee -> employee.getPosition().equals(Position.CHEF));
        boolean isRetired = employees.stream()
                .noneMatch(employee -> employee.getAge() > 63);
        boolean isAbleToWork = employees.stream()
                .allMatch(employee -> employee.getAge() > 18);
        Optional<Employee> max = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        Optional<Employee> min = employees.stream()
                .min(Comparator.comparingInt(Employee::getAge));
        int[] ints = employees.stream()
                .mapToInt(Employee::getAge)
                .toArray();
        Optional<String> reduce = employees.stream()
                .map(Employee::getFirstName)
                .reduce((f, s) -> f.concat(s));


        System.out.println(reduce.get());

//        employees.forEach(System.out::println);

        employees.stream().forEachOrdered(System.out::println);

        System.out.println(collect1);
        Set<Map.Entry<Integer, String>> entries = collect.entrySet();
        System.out.println(entries);
    }

    public static void terminatedMethodsNumbers() {
        List<Employee> employees = Data.employees;

        OptionalInt max = employees.stream()
                .mapToInt(Employee::getAge)
                .max();
        OptionalInt min = employees.stream()
                .mapToInt(Employee::getAge)
                .min();
        OptionalDouble average = employees.stream()
                .mapToInt(Employee::getAge)
                .average();
        int sum = employees.stream()
                .mapToInt(Employee::getAge)
                .sum();
        IntSummaryStatistics intSummaryStatistics = employees.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();
        Stream<StringBuffer> stringBufferStream = employees.stream()
                .mapToInt(Employee::getAge)
                .mapToObj(StringBuffer::new);

        double average1 = intSummaryStatistics.getAverage();
        long count = intSummaryStatistics.getCount();
        int max1 = intSummaryStatistics.getMax();
        int min1 = intSummaryStatistics.getMin();
        long sum1 = intSummaryStatistics.getSum();
    }

    /*
        Используйте unordered() когда порядок не обязателен.
        Не используйте parallelStream() или parallel() на маленьких коллекциях.
        На больших коллекциях сочетание parallelStream()
        (parallel()) совместно с unordered() дает максимальную производительность.
     */
    public static void parallelSequence() {
        List<Employee> employees = Data.employees;

        boolean parallel = employees.stream().isParallel();
        Stream<Employee> parallel1 = employees.stream().parallel();
        Stream<Employee> sequential = employees.stream().sequential();

        List<String> collect = employees.stream()
                .parallel()
                .filter(employee -> employee.getAge() > 30 && employee.getAge() < 50)
                .sequential()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());

        Stream<Employee> employeeStream = employees.parallelStream();

        List<Employee> collect1 = employees.parallelStream()
                .unordered()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toList());
    }
}
