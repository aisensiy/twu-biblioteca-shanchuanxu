package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;
    private UserInputHandler userInputHandler;
    private User currentUser;

    public List<Book> getBooks() {
        return books;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public BibliotecaApp() {
        init();
        prepareUserInputHandler();
    }

    public BibliotecaApp(List<Book> books) {
        this.books = books;
    }

    private void prepareUserInputHandler() {
        userInputHandler = new UserInputHandler();
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    public void init() {
        books = new ArrayList<>();
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
            case 3:
                returnBookCmd(); break;
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

    private void returnBookCmd() {
        String bookTitle = userInputHandler.getInput("Input The Book Name:");
        if (returnBook(bookTitle)) {
            System.out.println(String.format("Return book [%s] successfully!", bookTitle));
        } else {
            System.out.println(String.format("Failed to return book [%s]", bookTitle));
        }
    }

    public boolean checkoutBook(String bookTitle) {
        int idx = indexOfBookByTitle(bookTitle, books);
        Book book = books.get(idx);
        if (idx != -1 && book.getOwner() == null) {
            book.setOwner(currentUser);
            books.remove(idx);
            return true;
        } else {
            return false;
        }
    }

    private int indexOfBookByTitle(String bookTitle, List<Book> books) {
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
        String[] options = {"[1]List Books", "[2]Check out book", "[3]Return book", "[0]Quit"};

        System.out.println("Select action you want");
        for (String option : options) {
            System.out.println(option);
        }
    }

    private void listBooks() {
        for (Book book : books) {
            if (book.getOwner() == null) {
                System.out.println(book);
            }
        }
    }

    public boolean returnBook(String bookTitle) {
        int idx = indexOfBookByTitle(bookTitle, books);
        Book book = books.get(idx);
        if (idx != -1 && book.getOwner().equals(currentUser)) {
            book.setOwner(null);
            return true;
        } else {
            return false;
        }
    }
}
