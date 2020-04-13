package org.step.fifth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {

    public static void main(String[] args) throws Exception {
        Comparator<String> comparator = (first, second) -> {
            return Integer.compare(first.length(), second.length());
        };

        Comparator<String> stringComparator = Comparator.comparingInt(String::length);

        Runnable runnable = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Oops");
            }
            System.out.println("Yo!");
        };

        Callable<String> objectCallable = () -> {
            Thread.sleep(100);
            return "Yo I'am callable";
        };

        runnable.run();

        String call = objectCallable.call();
        System.out.println(call);

        // boolean test(String var1);
        // Если входных параметров > 1 то скобки нужны
        // Тип можно указать в скобках в передаваемых значениях
        // final модефикатор и аннотация final String str, @Nullable String str
        Predicate<String> stringPredicate = (final String str) -> str.length() > 5;

        String[] strings = {"sda", "dasfa", "as", "dsadqwef", "dsqewa"};

        boolean test = stringPredicate.test(strings[0]);

        System.out.println(test);

        // Comparator.comparingInt(String::length)
        // stringComparator
        Arrays.sort(strings, (first, second) -> {
            return Integer.compare(first.length(), second.length());
        });

        Arrays.stream(strings).forEach(System.out::println);

        Integer[] integers = {1, 4, 3, 5, 9, 2};

        Arrays.sort(integers, Integer::compareTo);

        Arrays.stream(integers).forEach(System.out::println);

        Supplier<String> listSupplier = String::new;
        String s = listSupplier.get();
    }
}
