import java.util.ArrayList;

public abstract class Location {
     protected ArrayList<Choice> currentChoices;
    protected String currentDialogue;
    protected String locationName;
    protected  ArrayList<Choice> choicesTaken;

    public Location () {

    }

    public String getCurrentDialog() {
        return this.currentDialogue;
    }

//    public String sendTerminate() {
//        return "terminate";
//    }

    public abstract void update(int days);
    public abstract void update(Choice choice ,int days);

    public ArrayList<Choice> getCurrentChoices() {
        return this.currentChoices;
    }

    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.currentChoices) {
            if (c.toString().equals(textRep)) {
                return c;
            }

        }
        return null;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void removeFromChoices(Choice c) {
        for (Choice internalchoice : this.getCurrentChoices()) {
            if (c.toString().equals(internalchoice.toString())) {
                this.currentChoices.remove(internalchoice);
                break;
            }
        }
    }

    public void getChoices() {
        for (Choice ch: this.currentChoices) {
            System.out.println(ch.textRep);
        }
    }
}
