import java.util.ArrayList;

public abstract class Location {
    private ArrayList<Choice> currentChoices;
    private String currentDialog;
    private ArrayList<Choice> choicesTaken;

    public Location () {

    }

    public abstract String getCurrentDialog();

    public String sendTerminate() {
        return "terminate";
    }

    public abstract ArrayList<String> getChoices();


}
