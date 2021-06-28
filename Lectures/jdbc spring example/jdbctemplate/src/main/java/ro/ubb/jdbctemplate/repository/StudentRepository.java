package ro.ubb.jdbctemplate.repository;

import ro.ubb.jdbctemplate.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    void save(Student student);
}
