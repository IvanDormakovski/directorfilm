package com.library.models;

import java.util.Date;

public class Film {
    private int id;
    private Director director;
    private String name;
    private Date releaseDate;
    private String genre;

    public Film() {
    }

    public Film(Director director, String name, Date releaseDate, String genre) {
        this.director = director;
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Film(int id, Director director, String name, Date releaseDate, String genre) {
        this.id = id;
        this.director = director;
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
