package ro.ubb.springdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.springdi.model.Student;
import ro.ubb.springdi.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
