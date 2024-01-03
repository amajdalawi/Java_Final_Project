import java.util.ArrayList;

public class THLocation extends Location{
    private ArrayList<Choice> currentChoices;
    String locationName;
    private String currentDialogue;
    private int daysSinceSendEmail;
    private int daysSinceGetTicket;


    public THLocation() {
        this.currentChoices = new ArrayList<>();
        this.locationName = "Town Hall";
        this.currentDialogue = """
                You are now at the Town Hall, what do you want to do?""";
        Choice c1 = new Choice("get ticket", "wait");
        Choice c2 = new Choice("return home", "goToBase");
        Choice c3 = new Choice("argue", "addToInventory", "Annex 100");
        Choice c4 = new Choice("send email", "wait");
        this.currentChoices.add(c1);
        this.currentChoices.add(c2);
        this.currentChoices.add(c3);
        this.currentChoices.add(c4);
    }
    @Override
    public String getCurrentDialog() {
        return this.currentDialogue;
    }

    @Override
    public void update(int days) {
        if (days - this.daysSinceGetTicket > 2) {
            Choice getAnnexChoice = new Choice("get annex", "addToInventory", "Annex 100");
            this.currentChoices.add(getAnnexChoice);
        }

        if (days - this.daysSinceSendEmail > 4) {
            Choice getAnnexChoice = new Choice("get annex", "addToInventory", "Annex 100");
            this.currentChoices.add(getAnnexChoice);
        }
    }


    @Override
    public void update(Choice choice, int days) {
        if (choice.textRep.equals("get ticket")) {
            this.daysSinceGetTicket = days;
            this.removeChoice(choice);


        }
    }
    public void removeChoice(Choice c) {
        for (Choice internalChoice : this.currentChoices) {
            if (c.textRep.equals(internalChoice.textRep)) {
                this.currentChoices.remove(internalChoice);
                break;
            }
        }
    }
    @Override
    public ArrayList<Choice> getCurrentChoices() {
        return this.currentChoices;
    }
    // Town hall Location

    public String getLocationName() {
        return this.locationName;
    }

    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.getCurrentChoices()){
            if (c.toString().equals(textRep)) {
                return c;
            }
        }
        return null;

    }

    public void getChoices() {
        for (Choice c: this.currentChoices) {
            System.out.println(c.textRep);
        }
    }
}
