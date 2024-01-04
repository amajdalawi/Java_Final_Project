package com.permitquest;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
    	System.out.println("\\______   \\  ____ _______   _____  |__|_/  |_                                     \r\n"
    			+ " |     ___/_/ __ \\\\_  __ \\ /     \\ |  |\\   __\\                                    \r\n"
    			+ " |    |    \\  ___/ |  | \\/|  Y Y  \\|  | |  |                                      \r\n"
    			+ " |____|     \\___  >|__|   |__|_|  /|__| |__|                                      \r\n"
    			+ "                \\/              \\/                                                \r\n"
    			+ "                                                                                  \r\n"
    			+ "                                        ________                            __    \r\n"
    			+ "                                        \\_____  \\   __ __   ____    _______/  |_  \r\n"
    			+ "                                         /  / \\  \\ |  |  \\_/ __ \\  /  ___/\\   __\\ \r\n"
    			+ "                                        /   \\_/.  \\|  |  /\\  ___/  \\___ \\  |  |   \r\n"
    			+ "                                        \\_____\\ \\_/|____/  \\___  >/____  > |__|  \n");
        
    	ContentLoader loader = new ContentLoader("src/permitquest.txt");
    	String playerName = loader.getValue("player_name");
        int playerHealth = Integer.parseInt(loader.getValue("player_health"));
        int playerDaysLeft = Integer.parseInt(loader.getValue("player_days_left"));
    	Player player = new Player(playerName, playerHealth , playerDaysLeft);
    	System.out.println("Hey " + playerName + loader.getValue("game_intro") + "\n");
    	//System.out.println("Hey " + playerName + ", fearless adventurer! Congrats on receiving your studies letter of acceptance.\nOops! I mean your conditional letter of accepantance for your future studies and the beginning\nto the Belgian bonanza! Time to dust off your shoes, grab your passport, pack that umbrella\n(we love animals so don't be surprised when it rains dogs and cats), and brace yourself for a\njourney filled with delicious chocolates, more languages than you'd expect, and more castles \nthan you can count. Fear not! Once you get your student permit, you'll finally be able to\ncatch your breath and fully savor what this beautiful country has to offer. After all,\ngreat things ain't easy, right?\n");
    	String location1Name = loader.getValue("location1_name");
    	String location1Intro = loader.getValue("location1_intro");
    	String location1Choice1 = loader.getValue("location1_choice1");
    	String location1Choice2 = loader.getValue("location1_choice2");
    	String location1Action1 = loader.getValue("location1_action1");
    	String location1Action2 = loader.getValue("location1_action2");
    	String location1Dialog1 = loader.getValue("location1_dialog1");
    	String location1Dialog2 = loader.getValue("location1_dialog2");
    	List<String> location1Choices = new ArrayList<>();
    	location1Choices.add(location1Choice1);
    	location1Choices.add(location1Choice2);
    	List<String> location1Actions = new ArrayList<>();
    	location1Actions.add(location1Action1);
    	location1Actions.add(location1Action2);
    	List<String> location1Dialogs = new ArrayList<>();
    	location1Dialogs.add(location1Dialog1);
    	location1Dialogs.add(location1Dialog2);
        Location startingLocation = new Location(location1Name, location1Intro, location1Choices, location1Actions, location1Dialogs);
        GameManager gameManager = GameManager.getInstance();
        ScreenPrinter screenPrinter = ScreenPrinter.getInstance();
        
        // Start the game
        gameManager.playGame(player, startingLocation, screenPrinter);
    }
}