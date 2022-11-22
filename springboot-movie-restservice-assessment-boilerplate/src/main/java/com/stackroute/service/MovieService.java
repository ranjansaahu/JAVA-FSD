package com.stackroute.service;

import com.stackroute.exceptions.MovieAlreadyExistException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.model.Movie;

import java.util.List;


public interface MovieService {

    public List<Movie> getAll();
    public Movie getById(int id) throws MovieNotFoundException;
    public Movie addNew(Movie emp) throws MovieAlreadyExistException;
}
