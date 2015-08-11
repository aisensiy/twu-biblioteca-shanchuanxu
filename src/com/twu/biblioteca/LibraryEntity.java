package com.twu.biblioteca;

public abstract class LibraryEntity {
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
