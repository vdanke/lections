package org.step.first.convention;

public class Runner {

    public static void main(String[] args) {
        CodeConv codeConv = new CodeConv();
        FirstInterface firstInterface = new JavaConv();

        String text = firstInterface.getText();

        System.out.println(text);

        Integer amount = codeConv.getAmount();

        System.out.println(amount);
    }
}
