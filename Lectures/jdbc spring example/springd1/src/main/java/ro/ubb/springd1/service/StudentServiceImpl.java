package ro.ubb.springd1.service;

import ro.ubb.springd1.model.Student;
import ro.ubb.springd1.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
