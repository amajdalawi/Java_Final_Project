package com.permitquest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ContentLoader {
	  private Map<String, String> gameContent;

	    public ContentLoader(String filePath) {
	        this.gameContent = new HashMap<>();
	        loadContent(filePath);
	    }

	    private void loadContent(String filePath) {
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                if (line.trim().isEmpty() || line.startsWith("#")) {
	                    // Ignore empty lines and comments
	                    continue;
	                }

	                String[] parts = line.split("=");
	                if (parts.length == 2) {
	                    String key = parts[0].trim();
	                    String value = parts[1].trim();
	                    gameContent.put(key, value);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public String getValue(String key) {
	        return gameContent.get(key);
	    }

	    public static void main(String[] args) {
	    	//probably add this to the Main.java class
	    	ContentLoader loader = new ContentLoader("game_content.txt");

	        // Example usage
	        String playerName = loader.getValue("player_name");
	        String playerHealth = loader.getValue("player_health");

	        System.out.println("Player Name: " + playerName);
	        System.out.println("Player Health: " + playerHealth);
	    }
}
