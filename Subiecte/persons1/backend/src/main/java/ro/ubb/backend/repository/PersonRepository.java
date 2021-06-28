package ro.ubb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.backend.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByNameContaining(String name);
}
