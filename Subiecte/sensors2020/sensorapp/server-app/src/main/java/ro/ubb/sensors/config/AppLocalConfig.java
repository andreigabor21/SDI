package ro.ubb.sensors.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ro.ubb.sensors.tcp.ClientHandler;
import ro.ubb.sensors.tcp.TcpServer;

@Configuration
@Import({JPAConfig.class})
@PropertySources({@PropertySource(value = "classpath:local/db.properties"),
})
public class AppLocalConfig {
    /**
     * Enables placeholders usage with SpEL expressions.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TcpServer server() {
        return new TcpServer();
    }

    @Bean
    public ClientHandler handler() {
        return new ClientHandler();
    }
}
