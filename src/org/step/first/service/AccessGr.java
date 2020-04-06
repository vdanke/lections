package org.step.first.service;

public class AccessGr extends Access {

    private String field;

    public AccessGr(String field) {
        super(field);
    }

    public void setField(String field) {
        this.field = field;
    }
}
