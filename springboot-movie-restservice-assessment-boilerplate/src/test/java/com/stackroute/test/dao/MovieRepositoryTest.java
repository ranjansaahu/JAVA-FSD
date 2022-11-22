package com.stackroute.test.dao;

import com.stackroute.dao.MovieRepository;
import com.stackroute.model.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;


    @Test
    public void givenNewMovieWhenSavedThenReturnMovie(){
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        Movie adddedMovie = movieRepository.save(movie);
        assertEquals(movie.getId(), adddedMovie.getId(), "New Movie should be saved and the same should be returned");
    }

    @Test
    public void givenInValidMovieIdThenReturnEmptyOptional(){
        assertTrue(movieRepository.findById(100).isEmpty());
    }

    @Test
    public void givenValidMovieIdThenReturnMovieOptional(){
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        movieRepository.save(movie);
        assertTrue(movieRepository.findById(100).isPresent());
    }
}