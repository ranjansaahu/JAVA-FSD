package com.stackroute.test.service;

import com.stackroute.dao.MovieRepository;
import com.stackroute.exceptions.MovieAlreadyExistException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.model.Movie;
import com.stackroute.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieServiceImpl movieService;


    @Test
    public void givenValidMovieIDThenShouldReturnMovie() throws MovieNotFoundException {
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        Optional<Movie> optionalMovie = Optional.of(movie);
        when(movieRepository.findById(100)).thenReturn(optionalMovie);
        Movie retreivedMovie = movieService.getById(100);
        assertEquals(movie.getId(), retreivedMovie.getId(),"should return movie for valid id of exixting movie");
    }

    @Test
    public void givenInValidMovieIDThenShouldThrowException() throws MovieNotFoundException {
        Optional<Movie> optionalMovie = Optional.empty();
        when(movieRepository.findById(100)).thenReturn(optionalMovie);
        assertThrows(MovieNotFoundException.class,()->{
            movieService.getById(100);});
    }

    @Test
    public void givenNewMovieWhenSavedShouldReturnMovie() throws MovieAlreadyExistException {
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        Optional<Movie> optionalMovie = Optional.empty();
        when(movieRepository.findById(100)).thenReturn(optionalMovie);
        Movie addedMovie = movieService.addNew(movie);
        verify(movieRepository,times(1)).findById(100);
        verify(movieRepository,times(1)).save(movie);
    }

    @Test
    public void givenDuplicateMovieWhenSavedShouldThrowException() throws MovieAlreadyExistException {
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        Optional<Movie> optionalMovie = Optional.of(movie);
        when(movieRepository.findById(100)).thenReturn(optionalMovie);
        assertThrows(MovieAlreadyExistException.class,()->{
            movieService.addNew(movie);});
        verify(movieRepository,times(1)).findById(100);
        verify(movieRepository,times(0)).save(movie);
    }
}