package ro.ubb.movieapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.ubb.movieapp.MovieAppApplication;
import ro.ubb.movieapp.model.Movie;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MovieAppApplication.class)
class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Test
    void getAllMovies() {
        movieService.getAllMovies().forEach(
                m -> System.out.println(m.getTitle())
        );
    }

    @Test
    void getMovieWithActors() {
        System.out.println(movieService.getMovieWithActors(7L));
    }

    @Test
    void addActor() {
        Movie movie = movieService.addActor(7L, 10L);
        System.out.println(movie.getActors());
    }
}