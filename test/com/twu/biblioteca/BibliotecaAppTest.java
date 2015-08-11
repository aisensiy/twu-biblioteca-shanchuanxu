package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp app;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() throws Exception {
        app = initApp();
    }

    @Test
    public void bookShouldGetOwnerAfterCheckout() {
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        app.checkoutBook("Head First Java");
        assertEquals("111-1112", book1.getOwner().getNumber());
    }

    @Test
    public void bookShouldHaveNoOwnerAfterCheckout() {
        app.setCurrentUser(new User("111-1111", "xxxxxx"));
        app.checkoutBook("Abc");
        assertEquals(null, book1.getOwner().getNumber());
    }

    @Test
    public void bookReturnedShouldNotInCheckedoutBooks() {
        BibliotecaApp app = initApp();
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        assertEquals(false, app.returnBook("Abc"));
    }

    @Test
    public void bookCannotBeCheckoutIfIsAlreadyCheckedout() {
        BibliotecaApp app = initApp();
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        assertEquals(false, app.checkoutBook("Abc"));
    }

    private BibliotecaApp initApp() {
        List<Book> books = new ArrayList<>();
        book1 = new Book("Head First Java", 2005, "A");
        books.add(book1);

        book2 = new Book("Abc", 2010, "B");
        book2.setOwner(new User("111-1111", "xxxxxx"));
        books.add(book2);

        return new BibliotecaApp(books);
    }
}