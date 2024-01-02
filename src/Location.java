import java.util.ArrayList;

public abstract class Location {
    private ArrayList choices;
    private String currentDialog;

    public Location () {

    }

    public abstract String getDialog();

    public String sendTerminate() {
        return "terminate";
    }

    public abstract ArrayList<String> getChoices();


}
