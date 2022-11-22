package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/* Annotate the class with @Entity annotation*/
@Entity
public class Movie {

    /* id is annotated with @Id */
    @Id
    private int id;
    private String movieName;
    private String language;
    private String genre;

    public Movie() {
    }

    /* Write parameterized constructor */
    public Movie(int id, String movieName, String language, String genre) {
        super();
        this.id = id;
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
    }

    /* Add getter and setter methods for all the properties */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
