package com.stackroute.controller;

import com.stackroute.exceptions.MovieAlreadyExistException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.model.Movie;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/* Annotate the class with @RestController and @RequestMapping */
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;


    /*
     * Constructor based Autowiring should be implemented
     */
    @Autowired
    public MovieController(MovieService movieService) {
        super();
        this.movieService = movieService;
    }


    /*
     * Define a handler method to get all the Movies. This handler method should map to
     * the URL "/movies". This method will return the List of movies in the response body
     *  with the Httpstatus OK.
     */
    @GetMapping("/api/v1/movies")
    public ResponseEntity<List<Movie>> getAllHandler(){
        return new ResponseEntity<List<Movie>>(movieService.getAll(), HttpStatus.OK);
    }


    /*
     * Define a handler method to add a new Movie. This handler method should map to
     * the URL "/movies". This method will return the saved movie in the response body
     *  with the Httpstatus CREATED, if the movie is saved successfully, else, returns the message
     * "Movie already Exist" with the status CONFLICT.
     */
    @PostMapping("api/v1/movies")
    public ResponseEntity<Movie> addNewHandler(@RequestBody Movie movie) {
        try {
            return new ResponseEntity<Movie>(movieService.addNew(movie), HttpStatus.CREATED);
        } catch (MovieAlreadyExistException e) {
            // TODO Auto-generated catch block
            return new ResponseEntity("Movie already Exist", HttpStatus.CONFLICT);
        }
    }




    /*
     * Define a handler method to add get a Movie by id. This handler method should map to
     * the URL "/movies/{id}". This method will return the retreived movie in the response body
     *  with the Httpstatus OK, if the movie is found, else, returns the message
     * "Movie Not found" with the status NOT_FOUND.
     */
    @GetMapping("api/v1/movies/{id}")
    public ResponseEntity<Movie> getByIdHandler(@PathVariable int id) {
        try {
            return new ResponseEntity<Movie>(movieService.getById(id), HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            // TODO Auto-generated catch block
            return new ResponseEntity("Movie Not found", HttpStatus.NOT_FOUND);
        }
    }
}
