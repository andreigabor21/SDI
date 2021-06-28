package ro.ubb.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movieapp.model.Movie;
import ro.ubb.movieapp.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesByYear(int year, boolean lessThan) {
        return lessThan ? movieRepository.findAllByYearLessThanEqual(year) : movieRepository.findAllByYearGreaterThanEqual(year);
    }

    @Override
    public List<Movie> getMoviesWithActorsByYear(int year, boolean lessThan) {
        return movieRepository.findAllWithActors()
                .stream()
                .filter(movie -> movie.getYear() <= year == lessThan)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteActor(Long movieId, Long actorId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.deleteActorById(actorId);
    }
}
