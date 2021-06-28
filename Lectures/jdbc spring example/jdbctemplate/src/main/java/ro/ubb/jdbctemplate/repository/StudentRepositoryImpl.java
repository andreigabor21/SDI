package ro.ubb.jdbctemplate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.jdbctemplate.model.Student;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            int grade = rs.getInt("grade");
            return new Student(id, name, grade);
        });
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student (name, grade) values (?, ?)";
        jdbcOperations.update(sql, student.getName(), student.getGrade());
    }
}
