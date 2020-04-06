package org.step.first;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Main {

    private static Integer a = 1;
    Short s;
    Byte b;
    Boolean isTrue;
    Long aLong;
    static int prim = 0;

    public static void main(String[] args) {
//        Date myDate = new Date();
//        System.out.println("Before " + myDate.getTime());
//        changeDate(myDate);
//        System.out.println("After " + myDate.getTime());

        List<Integer> integers = new ArrayList<>();
        integers.add(prim);

        double v = a.doubleValue();
        System.out.println(v);

        String first = "aaa";
        String second = new String("aaa");

        String str = "I like";
        System.out.println("Before " + str);
        String s = changeString(str);
        System.out.println("After " + s);
    }

    private static void changeDate(Date date) {
        System.out.println("Before change " + date.getTime());
        date.setTime(12);
        System.out.println("After change " + date.getTime());
    }

    private static String changeString(String str) {
        System.out.println("String before change " + str);
        str = str + " Java";
        System.out.println("String after change " + str);
        return str;
    }

    private static void example(long x) {
        int y = (int) x;
    }
}
