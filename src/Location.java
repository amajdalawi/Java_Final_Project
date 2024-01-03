import java.util.ArrayList;

public abstract class Location {
    private ArrayList<Choice> currentChoices;
    private String currentDialog;
    String locationName;
    private ArrayList<Choice> choicesTaken;

    public Location () {

    }

    public abstract String getCurrentDialog();

//    public String sendTerminate() {
//        return "terminate";
//    }

    public abstract void update(int days);
    public abstract void update(Choice choice ,int days);

    public abstract ArrayList<Choice> getCurrentChoices();

    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.currentChoices) {
            if (c.toString().equals(textRep)) {
                return c;
            }

        }
        return null;
    }

}
