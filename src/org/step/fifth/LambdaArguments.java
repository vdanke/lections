package org.step.fifth;

import org.step.fifth.data.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class LambdaArguments {

    public static void main(String[] args) {
        finalExampleVariable(true, 3);
        finalExampleVariable(false, 5);
    }

    private static void finalExampleVariable(boolean flag, int count) {
        Runnable runnable = () -> {
            if (flag) {
                for (int i = 0; i < count; i++) {
                    System.out.println("Flag is true, count: " + count);
                    Thread.yield();
                }
            } else {
                System.out.println("Flag is false, count: " + count);
            }
        };
        new Thread(runnable).start();
    }

    private static void effectiveFinalExampleVariable() {
        List<Object> objects = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("First");

        objects.add(new Employee());
        stringBuilder.append("second");

        for (Object obj : objects) {
            new Thread(() -> {
                if (!obj.getClass().isAssignableFrom(Employee.class)) {
                    objects.add(new Employee());
                    stringBuilder.append("third");
                }
            }).start();
        }
    }
}
