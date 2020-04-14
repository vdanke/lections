package org.step.sixth;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.step.sixth.Client.PORT;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);

            System.out.println("Started, waiting for connection");

            Socket socket = serverSocket.accept();

            System.out.println("Accepted " + serverSocket.getInetAddress());

            try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {

                byte[] buf = new byte[32 * 1024];
                int readBytes = inputStream.read(buf);
                String line = new String(buf, 0, readBytes);
                System.out.printf("Client> %s", line);

                outputStream.write(line.getBytes());
                outputStream.flush();
            }
        } finally {
            IoUtil.closeQuietly(serverSocket);
        }
    }
}
