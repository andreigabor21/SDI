package ro.ubb.sensors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ro.ubb.sensors.tcp.TcpServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ServerApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "ro.ubb.sensors.config"
        );
        TcpServer server = context.getBean(TcpServer.class);
        server.startServer();


        System.out.println("bye server");
    }
}
