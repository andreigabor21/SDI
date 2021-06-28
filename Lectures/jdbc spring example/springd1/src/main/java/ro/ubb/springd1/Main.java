package ro.ubb.springd1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.springd1.ui.Console;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello!");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.springd1.config");

        Console console = context.getBean(Console.class);
        console.runConsole();
    }
}
