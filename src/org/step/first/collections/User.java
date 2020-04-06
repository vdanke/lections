package org.step.first.collections;

public class User extends ParentUser<Integer> implements Comparable<String> {

    private int id;

    @Override
    public int compareTo(String s) {
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }
}
