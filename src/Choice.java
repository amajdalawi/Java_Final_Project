/**
 * Choice Class
 * The choice class represents a choice that can be mapped to a specific
 * input when enetered into standard input.
 *
 * @author abdulrahman almajdalawi
 *
 */
public class Choice {
    String type;
    Action typeOfAction;
    Location location = null;
    String item = null;
    String textRep;

    /**
     * Constructs a choice that can add an item to inventory
     * @param textRep - the text that's going to appear on the choices list
     * @param type - type of action the choice is going to represent
     * @param item - item to be added
     */
    public Choice(String textRep,Action type, String item) {
        this.item = item;
        this.textRep = textRep;
        this.typeOfAction = type;
    }

    /**
     * Constructs a choice that does a neutral action (doesn't add to inventory and doesn't go to locatino)
     * @param textRep - the text that's going to appear on the choices list
     * @param type - type of action the choice is going to represent
     */
    public Choice (String textRep, Action type) {
        this.textRep = textRep;
        this.typeOfAction = type;
    }

    /**
     * Constructs a choice that allows the currentLocation to change to a certain location
     *
     * @param textRep - the text that's going to appear on the choices list
     * @param type - type of action the choice is going to represent
     * @param l - location that will change after the player's choice
     */
    public Choice (String textRep, Action type, Location l) {
        this.textRep = textRep;
        this.typeOfAction = type;
        this.location = l;
    }

    /**
     * String representation of choice.
     * @return String string representation of choice
     */
    public String toString() {
        return this.textRep;
    }

    /**
     *
     * @return Action - returns action type of the choice
     */
    public Action getTypeOfAction() {
        return this.typeOfAction;
    }

}
