package org.step.third;

public class StringBufferBuilderExample {

    public static void main(String[] args) {
        /*
        Не потокобезопасный объект
         */
        StringBuilder stringBuilder = new StringBuilder();
        /*
        Потокобезопасный объект
         */
        StringBuffer stringBuffer = new StringBuffer();
        String example = "";
        StringBufferBuilderExample str = new StringBufferBuilderExample();
        str.stringBufferBuilder(stringBuilder, example, stringBuffer);
        System.out.println(stringBuilder.toString());
        System.out.println(example);
    }

    public void stringBufferBuilder(StringBuilder stringBuilder, String example, StringBuffer stringBuffer) {
        stringBuilder.append("My");
        stringBuilder.append(" name ");
        stringBuilder.append("is");

        example = example.concat("My name is");
    }
}
