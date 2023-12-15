package com.permitquest;

import java.util.Scanner;


public class ScreenPrinter {
    private static ScreenPrinter instance;

    private Scanner scanner;

    private ScreenPrinter() {
        this.scanner = new Scanner(System.in);
        // Initialize screen-related logic
    }

    public static ScreenPrinter getInstance() {
        if (instance == null) {
            instance = new ScreenPrinter();
        }
        return instance;
    }

    // Implement methods to print dialogues, parse input, show hints, etc.
    public void printDialogue(String dialogue) {
        // Implement logic to print dialogues to the screen
    }

    public String getPlayerChoice() {
        // Implement logic to get player input
        return scanner.nextLine();
    }

    public void clearScreen() {
        // Implement logic to clear the terminal window
    }

    // Close the Scanner when it's no longer needed
    public void closeScanner() {
        scanner.close();
    }
}