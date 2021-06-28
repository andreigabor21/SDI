package ro.ubb.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.movieapp.model.Actor;
import ro.ubb.movieapp.model.Movie;
import ro.ubb.movieapp.repository.ActorRepository;
import ro.ubb.movieapp.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public List<Actor> getAllAvailableActors() {
        List<Actor> collect = movieRepository.findAllWithActors()
                .stream()
                .map(Movie::getActors)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList()); //all actors who play in movies
        return actorRepository.findAll()
                .stream()
                .filter(actor -> !collect.contains(actor))
                .collect(Collectors.toList());
    }
}
