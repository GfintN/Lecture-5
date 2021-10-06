package by.it.academy.example.osparameters;

import java.net.*;

public class MACReader {

    public String GetMAC() {
        InetAddress ip;
        NetworkInterface network;
        try {
            ip = InetAddress.getLocalHost();
            network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return String.valueOf(sb);
        } catch (UnknownHostException | SocketException e) {
            return "UnknownMAC";
        }

    }
}
