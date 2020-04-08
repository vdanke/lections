package org.step.third;

import java.io.*;

public class InputOutputExample {

    public static void main(String[] args) throws IOException {
        FileCheckerUtil.fileChecker();

        InputOutputExample inputOutputExample = new InputOutputExample();

//        inputOutputExample.byteStreams();
//        inputOutputExample.fileOutputInputStreams();
//        inputOutputExample.pipedInputOutputStream();
        inputOutputExample.sequenceStream();
    }

    public void sequenceStream() throws IOException {
        FileInputStream inFileFirst = null;
        FileInputStream inFileSecond = null;
        SequenceInputStream sequenceStream = null;
        FileOutputStream outputStream = null;

        inFileFirst = new FileInputStream("material.txt");
        inFileSecond = new FileInputStream("stream_first.txt");
        sequenceStream = new SequenceInputStream(inFileFirst, inFileSecond);

        outputStream = new FileOutputStream("stream_second.txt");

        int readByte = sequenceStream.read();

        while (readByte != -1) {
            outputStream.write(readByte);
            readByte = sequenceStream.read();
        }
        inFileFirst.close();
        inFileSecond.close();
        sequenceStream.close();
        outputStream.close();
    }

    public void pipedInputOutputStream() throws IOException {
        PipedInputStream pipedIn = null;
        PipedOutputStream pipedOut = null;

        int[] toRead = null;

        pipedIn = new PipedInputStream();
        pipedOut = new PipedOutputStream(pipedIn);

        for (int i = 0; i < 20; i++) {
            pipedOut.write(i);
        }
        int willRead = pipedIn.available();
        toRead = new int[willRead];

        for (int i = 0; i < willRead; i++) {
            toRead[i] = pipedIn.read();
            System.out.println(toRead[i] + " ");
        }
        pipedIn.close();
        pipedOut.close();
    }

    public void fileOutputInputStreams() throws IOException {
        byte[] bytesToWrite = {1, 2, 3};
        byte[] bytesRead = new byte[10];

        String fileName = "stream_first.txt";

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;

        fileOutputStream = new FileOutputStream(fileName);
        System.out.println("File opened to write");

        fileOutputStream.write(bytesToWrite);
        System.out.println("Written: " + bytesToWrite.length + " bytes");

        fileOutputStream.close();
        System.out.println("Output stream is closed");

        fileInputStream = new FileInputStream(fileName);
        System.out.println("File opened for reading");

        int available = fileInputStream.available();
        System.out.println("Ready for reading " + available + " bytes");

        int count = fileInputStream.read(bytesRead, 0, available);
        System.out.println("Read " + count + " bytes");

        fileInputStream.close();
        System.out.println("Input stream is closed");
    }

    public void byteStreams() throws IOException {
        byte[] bytes = {1, -1, 0};

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int readInt = in.read();
        System.out.println("First element readInt is: " + readInt);
        readInt = in.read();
        System.out.println("Second element readInt is: " + readInt);
        readInt = in.read();
        System.out.println("Third element readInt is: " + readInt);

        out.write(10);
        out.write(11);

        byte[] outWrite = out.toByteArray();

        for (byte b : outWrite) {
            System.out.println(b);
        }

        in.close();
        out.close();
    }

}
