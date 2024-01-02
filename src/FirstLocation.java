import java.util.ArrayList;

public class FirstLocation extends Location {
    private String currentDialogue;
    private ArrayList<Choice> currentChoices;
    private ArrayList<Choice> choicesTaken;


    public FirstLocation() {
        this.currentDialogue = """
                Welcome to Brussels. As an international student, you are required to get your residence 
                permit in 8 days, and thus must get some items necessary to get your permit, if you fail to
                do so, you will lose and get kicked out of the country!
                Tread wisely!
                """ ;

    }

    @Override
    public String getCurrentDialog() {
        return this.currentDialogue;
    }



}
