import java.util.ArrayList;

public class BaseLocation extends Location {
//     String currentDialogue;
//     ArrayList<Choice> currentChoices;
//     ArrayList<Choice> choicesTaken;


    public BaseLocation(ArrayList<Location> lcs) {
//        System.out.println(lcs.toString());
//        for (Location l : lcs) {
//            System.out.println(l.locationName);
//        }
        this.currentChoices = new ArrayList<>();
        this.choicesTaken = new ArrayList<>();

        for (Location l: lcs) {
            Choice c = new Choice(l.getLocationName(), Action.GoToLocation, l);
            this.currentChoices.add(c);

        }

        this.currentDialogue = """
                You are now back at your home. Where do you want to go?
                """;
    }


    public void update(int days) {

    }

    public void update(Choice choice, int days) {

    }

    @Override
    public Choice getChoiceSelected(String textRep) {
        for (Choice c: this.getCurrentChoices()){
            if (c.toString().toLowerCase().equals(textRep)) {
                return c;
            }
        }
        return null;

    }

    @Override
    public void getChoices() {
        for (Choice c: this.currentChoices) {
            System.out.println(c.textRep);
        }
    }

}
