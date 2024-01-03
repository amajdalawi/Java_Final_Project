import java.util.ArrayList;

public class THLocation extends Location{
    private ArrayList<Choice> currentChoices;
    String locationName;
    private String currentDialogue;


    public THLocation() {
        this.locationName = "Town Hall";
        this.currentDialogue = """
                You are now at the Town Hall, what do you want to do?""";

    }
    @Override
    public String getCurrentDialog() {
        return this.currentDialogue;
    }

    @Override
    public void update(int days) {

    }

    @Override
    public void update(Choice choice, int days) {

    }

    @Override
    public ArrayList<Choice> getCurrentChoices() {
        return this.currentChoices;
    }
    // Town hall Location

    public String getLocationName() {
        return this.locationName;
    }

}
