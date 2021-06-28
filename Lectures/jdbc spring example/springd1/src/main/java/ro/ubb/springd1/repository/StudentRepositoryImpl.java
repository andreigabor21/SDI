package ro.ubb.springd1.repository;

import ro.ubb.springd1.model.Student;

import java.util.Arrays;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> findAll() {
        return Arrays.asList(new Student(1L, "s1", 10), new Student(2L, "s2", 10));
    }
}
