package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInputHandler {
    public String getInput(String prompt) {
        String result = null;
        System.out.print(prompt);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            result = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
