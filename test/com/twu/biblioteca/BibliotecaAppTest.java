package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp app;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
    }

    @Test
    public void getWelcomeWhenStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        app.run();
        assertTrue(outputStream.toString().startsWith("Welcome"));
    }

    @Test
    public void getMainMenuWhenStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        app.run();
        assertTrue(outputStream.toString().indexOf("List Books") != -1);
    }

    @Test
    public void bookShouldIncheckedoutBooksAfterCheckout() {
        assertEquals(0, app.getCheckedoutBooks().size());
        app.checkoutBook(app.getBooks().get(0).getTitle());
        assertEquals(1, app.getCheckedoutBooks().size());
    }

    @Test
    public void bookShouldRemovedFromBooksAfterCheckout() {
        assertEquals(3, app.getBooks().size());
        app.checkoutBook(app.getBooks().get(0).getTitle());
        assertEquals(2, app.getBooks().size());
    }
}