package org.step.first.service;

public class Access {

    private String field;

    public Access() {
    }

    public Access(String someField) {
        this.field = someField;
    }

    public String getField() {
        return field;
    }

    private void getSomething() {
    }

    protected void getSomethingNew() {
    }

    public void getSomethingByPublic() {
        getSomething();
    }

    @Override
    public int hashCode() {
        return field.length();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
