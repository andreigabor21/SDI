package ro.ubb.movieapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.ubb.movieapp.MovieAppApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MovieAppApplication.class)
class ActorServiceTest {

    @Autowired
    ActorService actorService;

    @Test
    void getAllActors() {
        actorService.getAllActors()
                .forEach(System.out::println);
    }

    @Test
    void getAllAvailableActors() {
        actorService.getAllAvailableActors()
                .forEach(System.out::println);
    }
}