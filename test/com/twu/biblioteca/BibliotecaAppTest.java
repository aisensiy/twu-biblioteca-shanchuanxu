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