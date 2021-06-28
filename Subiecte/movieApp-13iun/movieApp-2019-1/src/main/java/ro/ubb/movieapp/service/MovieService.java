package ro.ubb.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movieapp.model.Actor;
import ro.ubb.movieapp.model.Movie;
import ro.ubb.movieapp.repository.ActorRepository;
import ro.ubb.movieapp.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieWithActors(Long movieId) {
        return movieRepository.findMovieWithActorsById(movieId);
//        return movieRepository.findById(movieId).orElse(null);
    }

    @Transactional
    public Movie addActor(Long movieId, Long actorId) {
        Actor actor = actorRepository.findById(actorId).orElseThrow();
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.getActors().add(actor);
        return movie;
    }
}
