package ro.ubb.jdbctemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.ubb.jdbctemplate.repository.StudentRepository;
import ro.ubb.jdbctemplate.repository.StudentRepositoryImpl;
import ro.ubb.jdbctemplate.service.StudentService;
import ro.ubb.jdbctemplate.service.StudentServiceImpl;
import ro.ubb.jdbctemplate.ui.ClientConsole;

@Configuration
public class AppConfig {

    @Bean
    ClientConsole clientConsole() {
        return new ClientConsole(studentService());
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl(studentRepository());
    }

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }

}
