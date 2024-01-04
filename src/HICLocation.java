import java.util.ArrayList;

public class HICLocation extends Location implements LocationUpdatable {
    int daysSinceApplication;
    private boolean Applied = false;

    public HICLocation() {
        this.locationName = "Health Insurance Company";
        this.currentDialogue = "You are now at the Health Insurance Company? What are you going to do?";
        this.currentChoices = new ArrayList<Choice>();
        Choice c1 = new Choice("apply for health insurance", Action.Wait);
        Choice c2 = new Choice("return home", Action.GoToBase);
        currentChoices.add(c1);
        currentChoices.add(c2);


    }

    /**
     * Checks the days passed of the player against the days internal variable
     * @param days - days passed since the start of the game
     */
    @Override
    public void update(int days) {
        if (days - this.daysSinceApplication > 2 && this.Applied) {
            Choice getAnnexChoice = new Choice("get health certificate", Action.AddToInventory, "Health Insurance");
            this.currentChoices.add(getAnnexChoice);
        }
    }

    /**
     * adds choice and sets internal days variable
     * @param choice - choice instance to check against
     * @param days - days passed since start of game
     */
    @Override
    public void update(Choice choice, int days) {
        if (choice.textRep.equals("apply for health insurance")) {
            this.Applied = true;
            this.daysSinceApplication = days;
            this.removeFromChoices(choice);
            System.out.println("Come back after 2 days!");


        }
    }

    // Health Insurance Company Location
}
