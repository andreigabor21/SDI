package ro.ubb.springdi.ui;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.springdi.service.StudentService;

public class Console {

    @Autowired
    private StudentService studentService;

//    public Console(StudentService studentService) {
//        this.studentService = studentService;
//    }

    public void runConsole() {
        studentService.getAllStudents()
                .forEach(System.out::println);
    }
}
