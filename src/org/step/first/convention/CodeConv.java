package org.step.first.convention;

import org.step.first.AboutJava;

import java.util.*;

public class CodeConv implements FirstInterface, SecondInterface {

    public static final String NAME = "name";

    private String first;
    private Integer number;
    private AboutJava aboutJava;
    private Map<Integer, String> integerStringMap = new HashMap<>();

    private int prInt;
    private boolean isTrue;

    public CodeConv() {
        integerStringMap.put(1, "first");
        integerStringMap.put(2, "second");
    }

    public CodeConv(String first, Integer number) {
        this.first = first;
        this.number = number;
    }

    public void firstMethod() {
        System.out.println(first);
    }

    public Integer secondMethod() {
        return number;
    }

    public Integer getAmount() {
        int amount = 0;

        for (String s : getAllData()) {
            amount = amount + s.length();
        }
        return amount;
    }

    private List<String> getAllData() {
        List<String> stringList = new ArrayList<>();

        for (Integer integer : someMethod()) {
            stringList.add(integerStringMap.get(integer));
        }
        return stringList;
    }

    private Set<Integer> someMethod() {
        return integerStringMap.keySet();
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public AboutJava getAboutJava() {
        return aboutJava;
    }

    public void setAboutJava(AboutJava aboutJava) {
        this.aboutJava = aboutJava;
    }

    @Override
    public String getText() {
        return "This is code convention text";
    }
}
