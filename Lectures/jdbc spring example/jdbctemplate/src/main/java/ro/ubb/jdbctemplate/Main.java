package ro.ubb.jdbctemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.jdbctemplate.ui.ClientConsole;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.jdbctemplate.config");

        ClientConsole console = context.getBean(ClientConsole.class);
        console.runConsole();

        System.out.println("bye");
    }
}
