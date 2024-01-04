package com.permitquest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Location {
    String name;
    String intro;
    List<String> choices;
    List<String> actions;
    List<String> dialogs;
    int currentDialogIndex;

    public Location(String name, String intro, List<String> choices, List<String> actions, List<String> dialogs) {
        this.name = name;
        this.intro = intro;
        this.choices = choices;
        this.actions = actions;
        this.dialogs = dialogs;
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

    public String getIntro() {
        return intro;
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