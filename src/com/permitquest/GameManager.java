package com.permitquest;

import java.util.Iterator;

public class GameManager {
    private static GameManager instance;

    private String currentGameState;
    private Location currentLocation;
    private int attributeMeterLimit;

    private GameManager() {
        // Initialize game-related logic
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void playGame(Player player, Location startingLocation, ScreenPrinter screenPrinter) {
        setCurrentLocation(startingLocation);
        setCurrentGameState("Playing");

        while (!getCurrentGameState().equals("GameOver")) {
            // Display current location information
            System.out.println("You are at " + getCurrentLocation().getName() + "\n" + getCurrentLocation().getIntro() );

            // Display available choices
            Iterator<String> choiceIterator = getCurrentLocation().goToNextDialog();
            int choiceIndex = 0;
            while (choiceIterator.hasNext()) {
                System.out.println(choiceIndex + ". " + choiceIterator.next());
                choiceIndex++;
            }

            // Get player choice
            String playerChoice = screenPrinter.getPlayerChoice();

            // Process player choice
            try {
                choiceIndex = Integer.parseInt(playerChoice);
                runPlayerChoice(choiceIndex, player);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }

        // End the game when the game state is "GameOver"
        endGame();
    }

    private void runPlayerChoice(int choiceIndex, Player player) {
        getCurrentLocation().runChoice(choiceIndex);

        // Example: Update player attributes based on the choice
        player.makeChoice("Choice at index " + choiceIndex);

        // Example: Check for game-over conditions
        if (player.getHealth() <= 0) {
            setCurrentGameState("GameOver");
        }
    }

    public void endGame() {
        // Implement logic to conclude the game
        System.out.println("Game over. Thank you for playing!");
    }

    // Getters and setters for attributes
    public String getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(String currentGameState) {
        this.currentGameState = currentGameState;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getAttributeMeterLimit() {
        return attributeMeterLimit;
    }

    public void setAttributeMeterLimit(int attributeMeterLimit) {
        this.attributeMeterLimit = attributeMeterLimit;
    }
}