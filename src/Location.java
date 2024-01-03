import java.util.ArrayList;

public abstract class Location {
     protected ArrayList<Choice> currentChoices;
    protected String currentDialogue;
    protected String locationName;
    protected  ArrayList<Choice> choicesTaken;

    public Location () {

    }

    /**
     * get the dialogue of the location
     * @return String the dialogue of the location
     */
    public String getCurrentDialogue() {
        return this.currentDialogue;
    }

//    public String sendTerminate() {
//        return "terminate";
//    }

    public abstract void update(int days);
    public abstract void update(Choice choice ,int days);

    /**
     * return the currentChoices arraylist defined in the constructor of each Location
     * @return ArrayList this returns the current choices array list
     */
    public ArrayList<Choice> getCurrentChoices() {
        return this.currentChoices;
    }

    /**
     * return the Choice corresponding to the entered input
     * @param textRep the text entered in the standard input
     * @return Choice the choice corresponding to the textRep
     */
    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.getCurrentChoices()){
            if (c.toString().equals(textRep)) {
                return c;
            }
        }
        return null;
    }

    /**
     * get the name of the location
     * @return String the name of the location
     */
    public String getLocationName() {
        return this.locationName;
    }

    /**
     * remove a given choice
     * @param c Choice to be removed
     */
    public void removeFromChoices(Choice c) {
        for (Choice internalchoice : this.getCurrentChoices()) {
            if (c.toString().equals(internalchoice.toString())) {
                this.currentChoices.remove(internalchoice);
                break;
            }
        }
    }

    /**
     * print all the choices available in a certain location.
     *
     */
    public void getChoices() {
        for (Choice c: this.getCurrentChoices()) {
            System.out.println(c.textRep);
        }
    }
}
