package org.step.fifth;

import java.util.StringJoiner;

public class StringJoinerExample {

    public static void main(String[] args) {
        StringJoiner first = new StringJoiner("/");
        StringJoiner second = new StringJoiner("/", "{", "}");

        first.add("I'am first");
        second.add("I'am second");
        second.add("stringJoiner");

        int length = first.length();

        first.merge(second);
        first.setEmptyValue("Empty value");

        System.out.println(first.toString());
        System.out.println(second.toString());
    }
}
