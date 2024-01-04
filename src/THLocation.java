import java.util.ArrayList;

/**
 * Class representing town hall location
 */
public class THLocation extends Location implements LocationUpdatable{
    private int daysSinceSendEmail;
    private int daysSinceGetTicket;
    // A boolean variable to check whether the player sent email or not
    private boolean EmailSent = false;
    // A boolean variable to check whether the player got a ticket or not
    private boolean TicketTaken = false;


    public THLocation() {
        this.currentChoices = new ArrayList<>();
        this.locationName = "Town Hall";
        this.currentDialogue = """
                You are now at the Town Hall, what do you want to do?""";
        Choice c1 = new Choice("get ticket", Action.Wait);
        Choice c2 = new Choice("return home", Action.GoToBase);
        Choice c3 = new Choice("argue", Action.AddToInventory, "Annex 100");
        Choice c4 = new Choice("send email", Action.Wait);
        this.currentChoices.add(c1);
        this.currentChoices.add(c2);
        this.currentChoices.add(c3);
        this.currentChoices.add(c4);
    }

    /**
     * checks to see how many days has passed since the start of the game and compares it to the internal days variables set in the class
     * @param days - days passed since the start of the game
     */
    @Override
    public void update(int days) {
        if (days - this.daysSinceGetTicket > 2 && this.TicketTaken) {
            Choice getAnnexChoice = new Choice("get annex", Action.AddToInventory, "Annex 100");
            this.currentChoices.add(getAnnexChoice);
        }

        if (days - this.daysSinceSendEmail > 4 && this.EmailSent) {
            Choice getAnnexChoice = new Choice("get annex", Action.AddToInventory, "Annex 100");
            this.currentChoices.add(getAnnexChoice);
        }
    }


    /**
     * Sets the days internal variable and removes the selected choice
     * @param choice - choice instance to check against
     * @param days - days passed since start of game
     */
    @Override
    public void update(Choice choice, int days) {
        if (choice.textRep.equals("get ticket")) {
            this.daysSinceGetTicket = days;
            this.removeFromChoices(choice);
            this.TicketTaken = true;
        }

        if (choice.textRep.equals("send email")) {
            this.daysSinceSendEmail = days;
            this.removeFromChoices(choice);
            this.EmailSent = true;
        }
    }

    // Town hall Location



}
