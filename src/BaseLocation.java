import java.util.ArrayList;

public class BaseLocation extends Location {
    private String currentDialogue;
    private ArrayList<Choice> currentChoices;
    private ArrayList<Choice> choicesTaken;


    public BaseLocation(Location... lcs) {
        currentChoices = new ArrayList<>();
        choicesTaken = new ArrayList<>();

        for (Location l: lcs) {
            Choice c = new Choice(l.locationName, "goToLocation", l);
            currentChoices.add(c);
        }

        this.currentDialogue = """
                You are now back at your home. Where do you want to go?
                """;
//        this.currentDialogue = """
//                Welcome to Brussels. As an international student, you are required to get your residence
//                permit in 8 days, and thus must get some items necessary to get your permit, if you fail to
//                do so, you will lose and get kicked out of the country!
//                Tread wisely!""" ;
//        Choice choice1 = new Choice("proceed", "goToBase",null);
//        currentChoices.add(choice1);
    }

    @Override
    public String getCurrentDialog() {
        return this.currentDialogue;
    }

    @Override
    public ArrayList<Choice> getCurrentChoices() {
        return this.currentChoices;
    }

}
