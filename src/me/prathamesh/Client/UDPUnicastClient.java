package me.prathamesh.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPUnicastClient implements Runnable{

    private final int port;

    public UDPUnicastClient(int port){
        this.port = port;
    }

    @Override
    public void run() {
        try(DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[65507];
            socket.setSoTimeout(3000);
            while (true){
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);
                String msg  = new String(packet.getData());
                System.out.println(msg);
            }
        }
        catch (SocketException e){
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("Timeout: Closing client now.");
        }
    }
}
