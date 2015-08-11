package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;

    public BibliotecaApp() {
        initData();
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    public void initData() {
        books = new ArrayList<>();
        books.add(new Book("Head First Java", 2005, "A"));
        books.add(new Book("Test Driven Dev", 2002, "Kent"));
        books.add(new Book("Abc", 2010, "B"));
    }

    public void run() {
        boolean alive = true;
        int cmd;
        UserInputHandler userInputHandler = new UserInputHandler();

        welcome();
        showMainMenu();

        while (alive == true) {
            cmd = userInputHandler.getInput("Select One Option:");
            if (cmd == 0) {
                alive = false;
            } else {
                handleCmd(cmd);
            }
        }
    }

    private void handleCmd(int cmd) {
        switch (cmd) {
            case 1:
                listBooks(); break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private void welcome() {
        String msg = "Welcome";
        System.out.println(msg);
    }

    private void showMainMenu() {
        String[] options = {"[1]List Books", "[0]Quit"};

        System.out.println("Select action you want");
        for (String option : options) {
            System.out.println(option);
        }
    }

    private void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
