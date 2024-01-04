import java.util.ArrayList;

/**
 * Class of type Location representing the first location the player will be in
 */
public class FirstLocation extends Location {


    public FirstLocation() {
        currentChoices = new ArrayList<>();
        choicesTaken = new ArrayList<>();
        this.currentDialogue = """
                Welcome to Brussels. As an international student, you are required to get your residence 
                permit in 8 days, and thus must get some items necessary to get your permit, if you fail to
                do so, you will lose and get kicked out of the country!
                To get choices available, type help. 
                To display items in inventory, type inventory.
                To quit the game, type quit.
                Tread wisely!""" ;
        Choice choice1 = new Choice("proceed", Action.GoToBase);
        currentChoices.add(choice1);
    }

    @Override
    public void update(int days) {

    }

    @Override
    public void update(Choice choice, int days) {

    }

}
