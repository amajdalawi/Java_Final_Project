package com.permitquest;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int health;
    int daysLeft;
    List<String> choicesMade;
    Inventory inventory;
    // Add more attributes as needed

    public Player(String name, int health, int daysLeft) {
        this.name = name;
        this.health = health;
        this.daysLeft = daysLeft;
        this.choicesMade = new ArrayList<>();
        this.inventory = new Inventory();
        // Initialize other attributes as needed
    }

    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }


    // Method to make a choice
    public void makeChoice(String choice) {
        choicesMade.add(choice);
        // Implement any logic related to the choice
    }
}