package ro.ubb.springd1.repository;

import ro.ubb.springd1.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
