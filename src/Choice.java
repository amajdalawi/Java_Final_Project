/**
 * <h1>Choice Class</h1>
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
     * @param textRep
     * @param type
     * @param item
     */
    public Choice(String textRep,Action type, String item) {
        this.item = item;
        this.textRep = textRep;
        this.typeOfAction = type;
    }

    /**
     * Constructs a choice that does a neutral action (doesn't add to inventory and doesn't go to locatino)
     * @param textRep
     * @param type
     */
    public Choice (String textRep, Action type) {
        this.textRep = textRep;
        this.typeOfAction = type;
    }

    /**
     * Constructs a choice that allows the currentLocation to change to a certain location
     *
     * @param textRep
     * @param type
     * @param l
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

    public Action getTypeOfAction() {
        return this.typeOfAction;
    }

}
