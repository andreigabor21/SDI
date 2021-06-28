package ro.ubb.movieapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void getTitle() {
        Movie movie = new Movie();
        movie.setTitle("asd");
        assertSame("asd", movie.getTitle());
    }
}