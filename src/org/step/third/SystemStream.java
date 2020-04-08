package org.step.third;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Предопределенные потоки - System.in, System.out, System.err
 */
public class SystemStream {

    public static void main(String[] args) throws IOException {
        FileCheckerUtil.fileChecker();

        SystemStream.systemInOut();
    }

    public static void systemInOut() throws IOException {
        OutputStream outputStream = System.out;

        final int five = 5;
        final int hAscii = 104;

        // ASCII 'h'
        outputStream.write(hAscii);
        outputStream.flush();
        outputStream.write('\n');

        byte[] bytesFirst = new byte[five];

        InputStream firstIn = System.in;

        firstIn.read(bytesFirst);

        System.out.write(bytesFirst);
        System.out.write('\n');
        System.out.flush();

        InputStream secondIn = System.in;

        byte[] bytesSecond = new byte[five];

        int length = bytesSecond.length;

        for (int i = 0; i < length; i++) {
            bytesSecond[i] = (byte) secondIn.read();
        }
        System.out.println(bytesSecond[0] + " " + bytesSecond[1]);
        System.out.flush();
    }
}
