package by.it.academy.example.osparameters;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPReader {

    public String GetIP() {
        try {
            InetAddress ip = Inet4Address.getLocalHost();
            return String.valueOf(ip.getHostAddress());
        } catch (UnknownHostException e) {
            return "UnknownAddress";
        }
    }
}
