package ro.ubb.sensors.tcp;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TcpServer implements ApplicationContextAware {

    private ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    private int port = 2000;
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void startServer() {
        try (var serverSocket = new ServerSocket(this.port)) {
            System.out.println("server started; waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected");
                ClientHandler handler = context.getBean(ClientHandler.class);
                handler.setSocket(clientSocket);
                executorService.submit(handler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
