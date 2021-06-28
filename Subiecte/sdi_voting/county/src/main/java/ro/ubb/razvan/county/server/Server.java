package ro.ubb.razvan.county.server;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public static int aCount = 0;
    public static int bCount = 0;
    public static int cCount = 0;
    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void run() {
        String name;
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.print("name: ");
        name = scanner.next();
        System.out.print("id: ");
        id = scanner.nextInt();
        port = id + 2000;

        HandleVotingUpdate updateTask = new HandleVotingUpdate(name, restTemplate);
        executorService.submit(updateTask);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                HandleVotingScan handleVotingScan = new HandleVotingScan(socket);
                executorService.submit(handleVotingScan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
