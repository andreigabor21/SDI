package ro.ubb.movieapp.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.movieapp.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends MovieAppRepository<Movie, Long>{

    @Query("select distinct m from Movie m")
    @EntityGraph(value = "movieWithActors", type = EntityGraph.EntityGraphType.LOAD)
    List<Movie> findAllWithActors();

    List<Movie> findAllByYearLessThanEqual(int year);

    List<Movie> findAllByYearGreaterThanEqual(int year);
}
