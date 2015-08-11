package com.twu.biblioteca;

public class User {
    private String number;
    private String password;
    private UserInputHandler userInputHandler;

    public User(String number, String password) {
        this.number = number;
        this.password = password;
        userInputHandler = new UserInputHandler();
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getNumber().equals(user.getNumber());

    }

    @Override
    public int hashCode() {
        return getNumber().hashCode();
    }

    public User login(BibliotecaApp app) {
        return app.indexOfUserByNumberAndPassword(number, password);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }


}
