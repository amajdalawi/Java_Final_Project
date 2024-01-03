import java.util.ArrayList;

public class BaseLocation extends Location {
    private String currentDialogue;
    private ArrayList<Choice> currentChoices;
    private ArrayList<Choice> choicesTaken;


    public BaseLocation(ArrayList<Location> lcs) {
//        System.out.println(lcs.toString());
//        for (Location l : lcs) {
//            System.out.println(l.locationName);
//        }
        this.currentChoices = new ArrayList<>();
        this.choicesTaken = new ArrayList<>();

        for (Location l: lcs) {
            Choice c = new Choice(l.getLocationName(), "goToLocation", l);
            this.currentChoices.add(c);

        }

        this.currentDialogue = """
                You are now back at your home. Where do you want to go?
                """;
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

    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.getCurrentChoices()){
            if (c.toString().toLowerCase().equals(textRep)) {
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
