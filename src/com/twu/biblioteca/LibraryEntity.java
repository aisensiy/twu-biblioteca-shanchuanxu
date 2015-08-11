package com.twu.biblioteca;

public abstract class LibraryEntity {
    private User owner;
    private String title;

    public User getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LibraryEntity(String title) {
        this.title = title;
    }
}
