package ro.ubb.movieapp.service;


import ro.ubb.movieapp.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMoviesByYear(int year, boolean lessThan);

    List<Movie> getMoviesWithActorsByYear(int year, boolean lessThan);

    void deleteActor(Long movieId, Long actorId);
}
