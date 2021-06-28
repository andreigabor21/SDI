package ro.ubb.razvan.monitorweb.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ro.ubb.razvan.monitorcore.config.JPAConfig;

@Configuration
@ComponentScan({"ro.ubb.razvan.monitorcore"})
@Import({JPAConfig.class})
@PropertySources({@PropertySource(value = "classpath:local/db.properties")})
public class AppLocalConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
