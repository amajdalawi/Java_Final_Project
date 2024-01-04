package com.permitquest;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int health;
    int daysLeft;
    List<String> choicesMade;
    Inventory inventory;

    public Player(String name, int health, int daysLeft) {
        this.name = name;
        this.health = health;
        this.daysLeft = daysLeft;
        this.choicesMade = new ArrayList<>();
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getDaysLeft() {
        return daysLeft;
    }

    public void makeChoice(String choice) {
        choicesMade.add(choice);
        // Implement any logic related to the choice
    }
}