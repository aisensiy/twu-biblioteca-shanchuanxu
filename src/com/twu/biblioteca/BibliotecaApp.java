package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;
    private List<Movie> movies;
    private List<User> users;

    private UserInputHandler userInputHandler;
    private User currentUser;

    public BibliotecaApp() {
        init();
        prepareUserInputHandler();
    }

    public BibliotecaApp(List<Book> books, List<Movie> movies, List<User> users) {
        this.books = books;
        this.movies = movies;
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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
        books.add(new Book("A", 2011, "A"));
        movies = new ArrayList<>();
        users = new ArrayList<>();
        users.add(new Librarian("111-1111", "xxxxxx"));
        Customer c = new Customer("111-1112", "123");
        c.setAddress("Beijing");
        c.setEmail("aisensiy@163.com");
        c.setName("Xu");
        c.setPhoneNumber("+86-18511700000");
        users.add(c);
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
            case 4:
                listMovies(); break;
            case 5:
                checkoutMovieCmd(); break;
            case 6:
                returnMovieCmd(); break;
            case 7:
                loginCmd(); break;
            case 8:
                showCheckedoutBooksCmd(); break;
            case 9:
                showUserInfoCmd(); break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private void loginCmd() {
        String number = userInputHandler.getInput("Number:");
        String password = userInputHandler.getInput("Password:");
        User u = new User(number, password);
        u = u.login(this);
        if (u != null) {
            System.out.println("Login Success!");
            this.setCurrentUser(u);
        } else {
            System.out.println("Login Failed!");
        }
    }

    private void listMovies() {
        for (Movie movie : movies) {
            if (movie.getOwner() == null) {
                System.out.println(movie);
            }
        }
    }

    private void checkoutBookCmd() {
        String bookTitle = userInputHandler.getInput("Input The Book Name:");
        if (checkoutEntity(bookTitle, books)) {
            System.out.println(String.format("Checkout book [%s] successfully!", bookTitle));
        } else {
            System.out.println(String.format("Failed to checkout book [%s]", bookTitle));
        }
    }

    private void checkoutMovieCmd() {
        String movieTitle = userInputHandler.getInput("Input The Movie Name:");
        if (checkoutEntity(movieTitle, movies)) {
            System.out.println(String.format("Checkout Movie [%s] successfully!", movieTitle));
        } else {
            System.out.println(String.format("Failed to checkout movie [%s]", movieTitle));
        }
    }

    private void returnMovieCmd() {
        String movieTitle = userInputHandler.getInput("Input The Movie Name:");
        if (returnEntity(movieTitle, movies)) {
            System.out.println(String.format("Return movie [%s] successfully!", movieTitle));
        } else {
            System.out.println(String.format("Failed to return movie [%s]", movieTitle));
        }
    }

    private void returnBookCmd() {
        String bookTitle = userInputHandler.getInput("Input The Book Name:");
        if (returnEntity(bookTitle, books)) {
            System.out.println(String.format("Return book [%s] successfully!", bookTitle));
        } else {
            System.out.println(String.format("Failed to return book [%s]", bookTitle));
        }
    }

    public <E extends LibraryEntity> boolean checkoutEntity(String entityTitle, List<E> entities) {
        int idx = indexOfEntityByTitle(entityTitle, entities);
        if (idx != -1 && entities.get(idx).getOwner() == null) {
            E entity = entities.get(idx);
            entity.setOwner(currentUser);
            return true;
        } else {
            return false;
        }
    }

    private <E extends LibraryEntity> int indexOfEntityByTitle(String entityTitle, List<E> entities) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getTitle().equals(entityTitle)) {
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
        String[] options = {
                "[1]List Books", "[2]Check out book", "[3]Return book",
                "[4]List Movies", "[5]Check out movie", "[6]Return movie",
                "[7]Login",
                "[8]Show check-out books",
                "[9]Show user info",
                "[0]Quit"};

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

    public <E extends LibraryEntity> boolean returnEntity(String bookTitle, List<E> entities) {
        int idx = indexOfEntityByTitle(bookTitle, entities);
        LibraryEntity entity = entities.get(idx);
        if (idx != -1 && entity.getOwner().equals(currentUser)) {
            entity.setOwner(null);
            return true;
        } else {
            return false;
        }
    }

    public User indexOfUserByNumberAndPassword(String number, String password) {
        for (User user : users) {
            if (user.getNumber().equals(number) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public void showCheckedoutBooksCmd() {
        System.out.println("Checkedout Books:");
        for (Book book : books) {
            if (book.getOwner() != null) {
                System.out.println(book);
            }
        }
    }

    private void showUserInfoCmd() {
        if (getCurrentUser() instanceof Customer) {
            System.out.println(getCurrentUser().toString());
        }
    }
}
