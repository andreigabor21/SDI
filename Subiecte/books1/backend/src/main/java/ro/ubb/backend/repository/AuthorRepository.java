package ro.ubb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.backend.model.Author;
import ro.ubb.backend.model.Person;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


}
