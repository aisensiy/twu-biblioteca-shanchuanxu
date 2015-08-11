package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInputHandler {
    public int getInput(String prompt) {
        int result = 0;
        String line;
        System.out.print(prompt);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
            result = Integer.parseInt(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
