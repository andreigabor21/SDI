package ro.ubb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.backend.model.MyClass;

@Repository
public interface MyRepository extends JpaRepository<MyClass, Long> {
}
