import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import ro.ubb.razvan.county.server.Server;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.razvan.county.config");
        Server server = context.getBean(Server.class);
        RestTemplate restTemplate = context.getBean(RestTemplate.class);
        server.setRestTemplate(restTemplate);
        server.run();
    }
}
