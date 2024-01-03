import java.util.ArrayList;

public class THLocation extends Location{
    private ArrayList<Choice> currentChoices;
    String locationName;
    private String currentDialogue;
    private int daysSince;


    public THLocation() {
        this.currentChoices = new ArrayList<>();
        this.locationName = "Town Hall";
        this.currentDialogue = """
                You are now at the Town Hall, what do you want to do?""";
        Choice c1 = new Choice("get ticket", "wait");
        Choice c2 = new Choice("return home", "goToBase");
        Choice c3 = new Choice("argue", "addToInventory", "Annex 15");
        Choice c4 = new Choice("send email", "wait");
        this.currentChoices.add(c1);

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
