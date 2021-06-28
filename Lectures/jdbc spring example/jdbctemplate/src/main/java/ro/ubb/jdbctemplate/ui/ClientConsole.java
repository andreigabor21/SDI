package ro.ubb.jdbctemplate.ui;

import ro.ubb.jdbctemplate.service.StudentService;

public class ClientConsole {

    private StudentService studentService;

    public ClientConsole(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        studentService.getAllStudents()
                .forEach(System.out::println);
    }
}
