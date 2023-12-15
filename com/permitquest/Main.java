package com.permitquest;

public class Main {
    public static void main(String[] args) {
        // Create instances of updated classes
        Player player = new Player("VUB Student", 100, 10);
        Location startingLocation = new Location("Welkom to the Campus");
        GameManager gameManager = GameManager.getInstance();
        ScreenPrinter screenPrinter = ScreenPrinter.getInstance();

        // Start the game
        gameManager.playGame(player, startingLocation, screenPrinter);
    }
}