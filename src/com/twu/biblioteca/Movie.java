package com.twu.biblioteca;

public class Movie extends LibraryEntity {
    private int year;
    private String director;
    private int rating;

    public Movie(String title, int year, String director, int rating) {
        super(title);
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

}
