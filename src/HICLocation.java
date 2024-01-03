import java.util.ArrayList;

public class HICLocation extends Location  {
    int daysSinceApplication;

    public HICLocation() {
        this.locationName = "Health Insurance Company";
        this.currentDialogue = "You are now at the Health Insurance Company? What are you going to do?";
        this.currentChoices = new ArrayList<Choice>();
        Choice c1 = new Choice("apply for health insurance", "wait");
        Choice c2 = new Choice("return home", "goToBase");
        currentChoices.add(c1);
        currentChoices.add(c2);


    }

    @Override
    public void update(int days) {
        if (days - this.daysSinceApplication > 2) {
            Choice getAnnexChoice = new Choice("get health certificate", "addToInventory", "Health Insurance");
            this.currentChoices.add(getAnnexChoice);
        }
    }

    @Override
    public void update(Choice choice, int days) {
        if (choice.textRep.equals("apply for health insurance")) {
            this.daysSinceApplication = days;
            this.removeFromChoices(choice);
            System.out.println("Come back after 2 days!");


        }
    }

    // Health Insurance Company Location
}
