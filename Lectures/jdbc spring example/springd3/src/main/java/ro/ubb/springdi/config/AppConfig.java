package ro.ubb.springdi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ro.ubb.springdi.ui", "ro.ubb.springdi.service", "ro.ubb.springdi.repository"})
public class AppConfig {

    /*@Bean
    Console console() {
        return new Console();
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }*/
}
