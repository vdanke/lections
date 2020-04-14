package org.step.sixth;

import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class InetAddressExample {

    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

        inetAddress = InetAddress.getByName("www.youtube.com");
        System.out.println(inetAddress);

        InetAddress[] allInetAddresses = InetAddress.getAllByName("www.nba.com");

        for (InetAddress in : allInetAddresses) {
            System.out.println(in);
        }

        URL url = new URL("");
        URLConnection urlConnection = url.openConnection();
    }
}
