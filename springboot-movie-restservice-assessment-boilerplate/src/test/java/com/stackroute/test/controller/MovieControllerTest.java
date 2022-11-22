package com.stackroute.test.controller;

import com.stackroute.controller.MovieController;
import com.stackroute.exceptions.MovieAlreadyExistException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.model.Movie;
import com.stackroute.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }
    @Test
    public void givenNewMovieWhenPostThenReturnMovieJSON() throws Exception {
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        when(movieService.addNew(any())).thenReturn(movie);
        mockMvc.perform(post("/api/v1/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":100,\"movieName\":\"Welcome to Jungle\",\"language\":\"English\",\"genre\":\"Adventure\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(100));
    }

    @Test
    public void givenDuplicateMovieWhenPostThenReturnErrorMessage() throws Exception {
        when(movieService.addNew(any())).thenThrow(MovieAlreadyExistException.class);
        mockMvc.perform(post("/api/v1/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":100,\"movieName\":\"Welcome to Jungle\",\"language\":\"English\",\"genre\":\"Adventure\"}"))
                .andExpect(status().isConflict())
                .andExpect(content().string("Movie already Exist"));
    }

    @Test
    public void givenValidMovieIDWhenGETThenReturnMovie() throws Exception {
        Movie movie = new Movie(100,"Welcome to Jungle","English","Adventure");
        when(movieService.getById(anyInt())).thenReturn(movie);
        mockMvc.perform(get("/api/v1/movies/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(100));
    }

    @Test
    public void givenInValidMovieIDWhenGETThenReturnErrorMessage() throws Exception {

        when(movieService.getById(anyInt())).thenThrow(MovieNotFoundException.class);
        mockMvc.perform(get("/api/v1/movies/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Movie Not found"));
    }
}