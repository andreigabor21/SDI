package ro.ubb.springd1.ui;

import ro.ubb.springd1.service.StudentService;

public class Console {

    private StudentService studentService;

    public Console(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        studentService.getAllStudents()
                .forEach(System.out::println);
    }
}
