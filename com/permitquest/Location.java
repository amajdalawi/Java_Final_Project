package com.permitquest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Location {
    String name;
    List<String> choices;
    List<String> actions;
    List<String> dialogs;
    int currentDialogIndex;

    public Location(String name) {
        this.name = name;
        this.choices = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.dialogs = new ArrayList<>();
        this.currentDialogIndex = 0;
    }

    // Method to execute the chosen action
    public void runChoice(int choiceIndex) {
        if (choiceIndex >= 0 && choiceIndex < actions.size()) {
            String chosenAction = actions.get(choiceIndex);
            // Implement logic related to the chosen action
            System.out.println("Executing action: " + chosenAction);
        } else {
            System.out.println("Invalid choice index.");
        }
    }
    
    public String getName() {
        return name;
    }


    // Method to go to the next dialog
    public Iterator<String> goToNextDialog() {
        currentDialogIndex++;
        if (currentDialogIndex < dialogs.size()) {
            String currentDialog = dialogs.get(currentDialogIndex);
            System.out.println("Dialog: " + currentDialog);
        } else {
            System.out.println("No more dialogs in this location.");
        }

        // Return an iterator for the remaining choices
        return choices.iterator();
    }
}