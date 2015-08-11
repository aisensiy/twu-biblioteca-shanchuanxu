package com.twu.biblioteca;

public class Book extends LibraryEntity {
    private String title;
    private int publishedYear;
    private String author;

    public String getTitle() {
        return title;
    }

    public Book(String title, int publishedYear, String author) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-10s\t%d", title, author, publishedYear);
    }
}
