package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp app;

    @Test
    public void bookShouldIncheckedoutBooksAfterCheckout() {
        BibliotecaApp app = new BibliotecaApp();
        assertEquals(0, app.getCheckedoutBooks().size());
        app.checkoutBook(app.getBooks().get(0).getTitle());
        assertEquals(1, app.getCheckedoutBooks().size());
    }

    @Test
    public void bookShouldRemovedFromBooksAfterCheckout() {
        BibliotecaApp app = new BibliotecaApp();
        assertEquals(3, app.getBooks().size());
        app.checkoutBook(app.getBooks().get(0).getTitle());
        assertEquals(2, app.getBooks().size());
    }

    @Test
    public void bookReturnedShouldInBooks() {
        BibliotecaApp app = getTestBibliotecaAppWithCheckedoutBooks();

        app.returnBook("Abc");
        assertEquals(3, app.getBooks().size());
    }

    @Test
    public void bookReturnedShouldNotInCheckedoutBooks() {
        BibliotecaApp app = getTestBibliotecaAppWithCheckedoutBooks();
        app.returnBook("Abc");
        assertEquals(0, app.getCheckedoutBooks().size());
    }

    private BibliotecaApp getTestBibliotecaAppWithCheckedoutBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", 2005, "A"));
        books.add(new Book("Test Driven Dev", 2002, "Kent"));

        List<Book> checkedoutBooks = new ArrayList<>();
        checkedoutBooks.add(new Book("Abc", 2010, "B"));

        return new BibliotecaApp(books, checkedoutBooks);
    }
}