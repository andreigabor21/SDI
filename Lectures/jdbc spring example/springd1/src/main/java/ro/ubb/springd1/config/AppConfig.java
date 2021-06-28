package ro.ubb.springd1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ubb.springd1.repository.StudentRepository;
import ro.ubb.springd1.repository.StudentRepositoryImpl;
import ro.ubb.springd1.service.StudentService;
import ro.ubb.springd1.service.StudentServiceImpl;
import ro.ubb.springd1.ui.Console;

@Configuration
public class AppConfig {

    @Bean
    Console console() {
        return new Console(studentService());
    }

    private StudentService studentService() {
        return new StudentServiceImpl(studentRepository());
    }

    private StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }
}
