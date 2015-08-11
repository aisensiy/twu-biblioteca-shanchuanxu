package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void userShouldLoginWithRightIDAndPassword() {
        BibliotecaApp app = initApp();
        User u = new User("1", "0");
        assertEquals(null, u.login(app));

        u = new User("1", "x");
        assertEquals(u, u.login(app));
    }

    private BibliotecaApp initApp() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "x"));
        return new BibliotecaApp(new ArrayList<Book>(), new ArrayList<Movie>(), users);
    }
}