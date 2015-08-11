package com.twu.biblioteca;

public class Book extends LibraryEntity {
    private int publishedYear;
    private String author;

    public Book(String title, int publishedYear, String author) {
        super(title);
        this.publishedYear = publishedYear;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-10s\t%d", getTitle(), author, publishedYear);
    }
}
