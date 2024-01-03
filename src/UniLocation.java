import java.util.ArrayList;

public class UniLocation extends  Location {

    public UniLocation() {
        this.locationName = "University";
        this.currentChoices = new ArrayList<Choice>();
        this.currentDialog = "You are now at the University, what are you going to do?";
        Choice c1 = new Choice("return home", "goToBase");
        Choice c2 = new Choice("get registration certificate", "addToInventory", "Registration Certificate");
        this.currentChoices.add(c1);
        this.currentChoices.add(c2);

    }
    @Override
    public String getCurrentDialog() {
        return this.currentDialog;
    }

    @Override
    public void update(int days) {

    }

    @Override
    public void update(Choice choice, int days) {

    }


    @Override
    public ArrayList<Choice> getCurrentChoices() {
        return null;
    }

    public void getChoices() {
        for (Choice ch: this.currentChoices) {
            System.out.println(ch.textRep);
        }
    }
}
