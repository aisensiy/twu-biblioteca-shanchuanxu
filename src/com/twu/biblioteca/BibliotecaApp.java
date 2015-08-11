package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;
    private List<Book> checkedoutBooks;
    private UserInputHandler userInputHandler;

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getCheckedoutBooks() {
        return checkedoutBooks;
    }

    public BibliotecaApp() {
        initData();
        userInputHandler = new UserInputHandler();
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

        checkedoutBooks = new ArrayList<>();
    }

    public void run() {
        boolean alive = true;
        String line = null;
        int cmd;
        UserInputHandler userInputHandler = new UserInputHandler();

        welcome();
        showMainMenu();

        while (alive == true) {
            line = userInputHandler.getInput("Select One Option:");
            cmd = Integer.parseInt(line);
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
            case 2:
                checkoutBookCmd(); break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private void checkoutBookCmd() {
        String bookTitle = userInputHandler.getInput("Input The Book Name:");
        if (checkoutBook(bookTitle)) {
            System.out.println(String.format("Checkout book [%s] successfully!", bookTitle));
        } else {
            System.out.println(String.format("Failed to checkout book [%s]", bookTitle));
        }
    }

    public boolean checkoutBook(String bookTitle) {
        int idx = indexOfBookByTitle(bookTitle);
        if (idx != -1) {
            checkedoutBooks.add(books.get(idx));
            books.remove(idx);
            return true;
        } else {
            return false;
        }
    }

    private int indexOfBookByTitle(String bookTitle) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(bookTitle)) {
                return i;
            }
        }
        return -1;
    }


    private void welcome() {
        String msg = "Welcome";
        System.out.println(msg);
    }

    private void showMainMenu() {
        String[] options = {"[1]List Books", "[2]Check out book", "[0]Quit"};

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
