package org.step.third;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ReaderWriterExample {

    public static void main(String[] args) throws IOException {
        FileCheckerUtil.fileChecker();

        ReaderWriterExample readerWriterExample = new ReaderWriterExample();
//        readerWriterExample.charArrayReader();
//        readerWriterExample.bufferedWriter();
//        readerWriterExample.pushBackReader();
        readerWriterExample.fileReader();
    }

    public void charArrayReader() throws IOException {
        String tmp = "abcdefghijklmnopqrstuvwxyz";

        int length = tmp.length();
        char[] chars = new char[length];

        tmp.getChars(0, length, chars, 0);
        CharArrayReader inputFirst = new CharArrayReader(chars);
        CharArrayReader inputSecond = new CharArrayReader(chars, 0, 5);

        int toRead;

        System.out.println("inputFirst is: ");
        while ((toRead = inputFirst.read()) != -1) {
            System.out.print((char) toRead);
        }
        System.out.println();

        System.out.println("inputSecond is: ");
        while ((toRead = inputSecond.read()) != -1) {
            System.out.print((char) toRead);
        }
        inputFirst.close();
        inputSecond.close();
    }

    public void bufferedWriter() throws IOException {
        Writer out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("stream_second.txt"), StandardCharsets.UTF_8
                )
        );

        try {
            out.write("asdf");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Writing failed");
        } finally {
            out.close();
        }
    }

    public void pushBackReader() throws IOException {
        String str = "if (a == 4) a = 0;\n";

        char[] buffer = new char[str.length()];

        str.getChars(0, str.length(), buffer, 0);

        CharArrayReader charArrayReader = new CharArrayReader(buffer);
        PushbackReader pushbackReader = new PushbackReader(charArrayReader);

        int reader;

        while ((reader = pushbackReader.read()) != -1) {
            switch (reader) {
                case '=':
                    if ((reader = pushbackReader.read()) == '=')
                        System.out.print(".eq.");
                    else {
                        System.out.print("<-");
                        pushbackReader.unread(reader);
                    }
                    break;
                default:
                    System.out.print((char) reader);
                    break;
            }
        }
        charArrayReader.close();
        pushbackReader.close();
    }

    public void fileReader() {
        try (FileReader fileReader = new FileReader("src/org/step/third/FileCheckerUtil.java")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str;

            str = bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(str);

//            while ((str = bufferedReader.readLine()) != null) {
//                System.out.println(str);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
