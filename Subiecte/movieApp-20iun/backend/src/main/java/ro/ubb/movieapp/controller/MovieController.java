package ro.ubb.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movieapp.converter.MovieConverter;
import ro.ubb.movieapp.dto.MovieDto;
import ro.ubb.movieapp.model.Movie;
import ro.ubb.movieapp.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movieapp")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieConverter movieConverter;

//    @GetMapping("/movies/{year}/{lessThan}")
//    public ResponseEntity<List<MovieDto>> getMoviesByYear(@PathVariable int year, @PathVariable boolean lessThan) {
//        return new ResponseEntity<>(this.movieConverter.convertModelsToDtos(this.movieService.getMoviesByYear(year, lessThan)), HttpStatus.OK);
//    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getMoviesByYear(@RequestParam int year,
                                                          @RequestParam boolean lessThan) {
        List<Movie> moviesByYear = movieService.getMoviesByYear(year, lessThan);
        List<MovieDto> movieDtosNoActors = moviesByYear.stream()
                .map(movieConverter::convertModelToDtoWithoutActors)
                .collect(Collectors.toList());
        return new ResponseEntity<>(movieDtosNoActors, HttpStatus.OK);
    }

    @GetMapping("/movies-actors")
    public ResponseEntity<List<MovieDto>> getMoviesByYearWithActors(@RequestParam int year,
                                                          @RequestParam boolean lessThan) {
        List<Movie> moviesByYear = movieService.getMoviesWithActorsByYear(year, lessThan);
        List<MovieDto> movieDtosNoActors = moviesByYear.stream()
                .map(movieConverter::convertModelToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(movieDtosNoActors, HttpStatus.OK);
    }

    @PostMapping("/movies/{movieId}/{actorId}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long movieId,
                                         @PathVariable Long actorId) {
        movieService.deleteActor(movieId, actorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
