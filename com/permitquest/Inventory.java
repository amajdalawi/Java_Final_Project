package com.permitquest;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        items.add(item);
        // Add any additional logic related to adding an item
    }
}