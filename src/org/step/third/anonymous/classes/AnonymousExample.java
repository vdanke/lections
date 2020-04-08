package org.step.third.anonymous.classes;

import org.step.second.annot.MyAnnotation;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class AnonymousExample {

    private static Comparator<String> stringComparator = (first, second) -> {
        if (first.length() > second.length()) {
            return 1;
        } else if (first.length() < second.length()) {
            return -1;
        } else {
            return 0;
        }
    };

    private static Function<String, Integer> stringIntegerFunction = String::hashCode;

    private static Predicate<Integer> predicate = integer -> integer > 1;

    ExampleInterface exampleInterface = () -> "Hello";

    public static void main(String[] args) {
        Comparator<String> tComparator = Comparator.naturalOrder();

        Set<String> stringSet = new TreeSet<>((final String first, @MyAnnotation String second) -> {
            if (first.length() > second.length()) {
                return 1;
            } else if (first.length() < second.length()) {
                return -1;
            } else {
                return 0;
            }
        });
        stringComparator.thenComparing(stringIntegerFunction);

        stringSet.add("abcd");
        stringSet.add("ab");
        stringSet.add("a");
        stringSet.add("abc");

        for (String str : stringSet) {
            System.out.println(str);
        }

        ExampleInterface exampleInterface = new FirstClass() {
            @Override
            public String saySomething() {
                return super.saySomething();
            }
        };
        System.out.println(exampleInterface.saySomething());
    }


}
