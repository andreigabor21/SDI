package ro.ubb.movieapp.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.ubb.movieapp.MovieAppApplication;
import ro.ubb.movieapp.model.Actor;
import ro.ubb.movieapp.model.Movie;
import ro.ubb.movieapp.repository.MovieRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = MovieAppApplication.class)
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void findAllWithActors() {
//        Actor actor1 = new Actor("andrei", 10);
//        Actor actor2 = new Actor("matei", 9);
//        Movie movie1 = new Movie("movie1", 2020, Arrays.asList(actor1, actor2));
//        movieRepository.save(movie1);

        List<Movie> all = movieRepository.findAllWithActors();
        all.forEach(System.out::println);
    }

    @Test
    void findAllWithActorsById() {
        Movie movie = movieRepository.findMovieWithActorsById(7L);
        System.out.println(movie);
    }
}