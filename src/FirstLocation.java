import java.util.ArrayList;

public class FirstLocation extends Location {
    private String currentDialogue;
    private ArrayList<Choice> currentChoices;
    private ArrayList<Choice> choicesTaken;


    public FirstLocation() {
        currentChoices = new ArrayList<>();
        choicesTaken = new ArrayList<>();
        this.currentDialogue = """
                Welcome to Brussels. As an international student, you are required to get your residence 
                permit in 8 days, and thus must get some items necessary to get your permit, if you fail to
                do so, you will lose and get kicked out of the country!
                Tread wisely!""" ;
        Choice choice1 = new Choice("proceed", "goToBase");
        currentChoices.add(choice1);
    }

    @Override
    public String getCurrentDialog() {
        return this.currentDialogue;
    }

    @Override
    public ArrayList<Choice> getCurrentChoices() {
        return this.currentChoices;
    }


//    public Choice getChoiceSelected(String textRep) {
//        for (Choice c: this.getCurrentChoices()){
//            if (c.toString().equals(textRep)) {
//                return c;
//            }
//        }
//        return null;
//
//    }


}
