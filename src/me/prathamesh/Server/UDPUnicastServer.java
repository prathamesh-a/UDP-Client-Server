package me.prathamesh.Server;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPUnicastServer implements Runnable{

    private final int clientPort;

    public UDPUnicastServer(int clientPort){
        this.clientPort = clientPort;
    }


    @Override
    public void run() {
        try(DatagramSocket socket = new DatagramSocket(50000)) {
            String msg = "Hello!";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), clientPort);
            socket.send(packet);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
