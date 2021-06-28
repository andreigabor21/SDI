package ro.ubb.jdbctemplate.service;

import ro.ubb.jdbctemplate.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
}
