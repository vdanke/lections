package org.step.third.anonymous.classes;

public class FirstClass implements ExampleInterface {

    public void getSomethingElse() {
        System.out.println("Something else");
    }

    @Override
    public String saySomething() {
        return "First class is saying";
    }
}
