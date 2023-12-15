package com.permitquest;

public class Item {
    String name;

    public Item(String name) {
        this.name = name;
        // Initialize other attributes as needed
    }
    
    public String getName() {
        return name;
    }

    // Method to perform an action specific to the item
    public void doSomething() {
        // Implement logic specific to the item
        System.out.println("The " + name + " does something!");
    }
}