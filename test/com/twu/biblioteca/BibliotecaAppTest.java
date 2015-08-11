package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Test
    public void getWelcomeWhenStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BibliotecaApp app = new BibliotecaApp();
        app.run();
        assertTrue(outputStream.toString().startsWith("Welcome"));
    }

    @Test
    public void getMainMenuWhenStart() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BibliotecaApp app = new BibliotecaApp();
        app.run();
        assertTrue(outputStream.toString().indexOf("List Books") != -1);
    }
}