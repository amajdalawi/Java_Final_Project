import java.util.ArrayList;

public class EmbassyLocation extends  Location {
//    private ArrayList<Choice> currentChoices;
//    private String currentDialogue;
//    private String locationName;

    public EmbassyLocation() {
        this.currentChoices = new ArrayList<Choice>();
        this.currentDialogue = "You are now at the Embassy, what are you going to do?";
        this.locationName = "Embassy";
        Choice c1 = new Choice("return home", "goToBase");
        Choice c2 = new Choice("get birth certificate", "addToInventory", "Birth Certificate");
        this.currentChoices.add(c1);
        this.currentChoices.add(c2);

    }

    public String getLocationName() {
        return this.locationName;
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

    @Override
    public void getChoices() {
        for (Choice c: this.currentChoices) {
            System.out.println(c.textRep);
        }
    }

    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.currentChoices) {
            if (c.toString().equals(textRep)) {
                return c;
            }

        }
        return null;
    }

}
