package ro.ubb.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movieapp.converter.ActorConverter;
import ro.ubb.movieapp.converter.MovieConverter;
import ro.ubb.movieapp.dto.ActorDto;
import ro.ubb.movieapp.dto.MovieDto;
import ro.ubb.movieapp.model.Actor;
import ro.ubb.movieapp.model.Movie;
import ro.ubb.movieapp.service.ActorService;
import ro.ubb.movieapp.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/movieapp")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getAllActors() {
        List<Movie> allMovies = movieService.getAllMovies();
        List<MovieDto> allMovieDtosWithoutActors = allMovies
                                .stream()
                                .map(movieConverter::convertModelToDtoWithoutActors)
                                .collect(Collectors.toList());
        return new ResponseEntity<>(allMovieDtosWithoutActors, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long id) {
        return new ResponseEntity<>(movieConverter.convertModelToDto(
                movieService.getMovieWithActors(id)
        ), HttpStatus.OK);
    }

    @PostMapping("/movie/new/{movieId}/{actorId}")
    public ResponseEntity<MovieDto> addActorToMovie(@PathVariable Long movieId,
                                                    @PathVariable Long actorId) {
        return new ResponseEntity<>(movieConverter.convertModelToDto(
                movieService.addActor(movieId, actorId)),
                HttpStatus.OK
        );
    }
}
