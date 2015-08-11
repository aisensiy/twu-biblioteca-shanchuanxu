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
    private Movie movie1;
    private Movie movie2;

    @Before
    public void setUp() throws Exception {
        app = initApp();
    }

    @Test
    public void bookShouldGetOwnerAfterCheckout() {
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        app.checkoutEntity("Head First Java", app.getBooks());
        assertEquals("111-1112", book1.getOwner().getNumber());
    }

    @Test
    public void bookShouldHaveNoOwnerAfterReturn() {
        app.setCurrentUser(new User("111-1111", "xxxxxx"));
        app.returnEntity("Abc", app.getBooks());
        assertEquals(null, book2.getOwner());
    }

    @Test
    public void bookCanOnlyReturnByItsOwner() {
        BibliotecaApp app = initApp();
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        assertEquals(false, app.returnEntity("Abc", app.getBooks()));
    }

    @Test
    public void bookCannotBeCheckoutIfIsAlreadyCheckedout() {
        BibliotecaApp app = initApp();
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        assertEquals(false, app.checkoutEntity("Abc", app.getBooks()));
    }

    @Test
    public void movieShouldGetOwnerAfterCheckout() {
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        app.checkoutEntity("A", app.getMovies());
        assertEquals("111-1112", movie1.getOwner().getNumber());
    }

    @Test
    public void movieShouldHaveNoOwnerAfterReturn() {
        app.setCurrentUser(new User("111-1111", "xxxxxx"));
        app.returnEntity("B", app.getMovies());
        assertEquals(null, movie2.getOwner());
    }

    @Test
    public void movieCanOnlyReturnByItsOwner() {
        BibliotecaApp app = initApp();
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        assertEquals(false, app.returnEntity("B", app.getMovies()));
    }

    @Test
    public void movieCannotBeCheckoutIfIsAlreadyCheckedout() {
        BibliotecaApp app = initApp();
        app.setCurrentUser(new User("111-1112", "xxxxxx"));
        assertEquals(false, app.checkoutEntity("B", app.getMovies()));
    }

    private BibliotecaApp initApp() {
        List<Book> books = new ArrayList<>();
        book1 = new Book("Head First Java", 2005, "A");
        books.add(book1);

        book2 = new Book("Abc", 2010, "B");
        book2.setOwner(new User("111-1111", "xxxxxx"));
        books.add(book2);

        List<Movie> movies = new ArrayList<>();
        movie1 = new Movie("A", 2000, "A", 5);
        movies.add(movie1);
        movie2 = new Movie("B", 2000, "B", 5);
        movie2.setOwner(new User("111-1111", "xxxxxx"));
        movies.add(movie2);

        return new BibliotecaApp(books, movies, new ArrayList<User>());
    }
}