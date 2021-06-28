package ro.ubb.movieapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.ubb.movieapp.dto.MovieDto;
import ro.ubb.movieapp.model.Movie;

@Component
public class MovieConverter extends AbstractConverterBaseEntityConverter<Movie, MovieDto> {

    @Autowired
    private ActorConverter actorConverter;

    @Override
    public Movie convertDtoToModel(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setYear(movieDto.getYear());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = MovieDto.builder()
                .title(movie.getTitle())
                .year(movie.getYear())
                .actors(actorConverter.convertModelsToDtos(movie.getActors()))
                .build();
        movieDto.setId(movie.getId());
        return movieDto;
    }

    public MovieDto convertModelToDtoWithoutActors(Movie movie) {
        MovieDto movieDto = MovieDto.builder()
                .title(movie.getTitle())
                .year(movie.getYear())
                .build();
        movieDto.setId(movie.getId());
        return movieDto;
    }

}