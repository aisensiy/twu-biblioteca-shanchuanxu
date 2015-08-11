package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
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
                System.out.println("Show books"); break;
            default:
                System.out.println("Select a valid option!");
        }
    }

    private void welcome() {
        String msg = "Welcome";
        System.out.println(msg);
    }

    private void showMainMenu() {
        String[] options = {"List Books", "Quit"};

        System.out.println("Select action you want");
        for (String option : options) {
            System.out.println(option);
        }
    }
}
