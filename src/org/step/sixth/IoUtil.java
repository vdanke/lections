package org.step.sixth;

import java.net.ServerSocket;
import java.net.Socket;

public class IoUtil {

    public static void closeQuietly(Socket socket) throws Exception {
        if (socket != null) {
            socket.close();
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) throws Exception {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
