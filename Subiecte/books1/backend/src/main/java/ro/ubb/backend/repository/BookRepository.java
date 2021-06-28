package ro.ubb.backend.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.backend.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select distinct book from Book book")
    @EntityGraph(value = "bookWithAuthor", type = EntityGraph.EntityGraphType.FETCH)
    List<Book> findAllWithAuthors();
}
