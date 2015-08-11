package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void run() {
        welcome();
        showMainMenu();
    }

    private void welcome() {
        String msg = "Welcome";
        System.out.println(msg);
    }

    private void showMainMenu() {
        String[] options = {"List Books", "Quit"};

        System.out.println("Select action you want:");
        for (String option : options) {
            System.out.println(option);
        }
    }
}
