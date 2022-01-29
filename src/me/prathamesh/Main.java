package me.prathamesh;

import me.prathamesh.Client.UDPUnicastClient;
import me.prathamesh.Server.UDPUnicastServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int port = 50001;
        UDPUnicastServer server = new UDPUnicastServer(port);
        UDPUnicastClient client = new UDPUnicastClient(port);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(server);
        service.submit(client);
    }
}
