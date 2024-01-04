import java.util.ArrayList;

/**
 * Class representing the location of the university
 */
public class UniLocation extends  Location {

    public UniLocation() {
        this.locationName = "University";
        this.currentChoices = new ArrayList<Choice>();
        this.currentDialogue = "You are now at the University, what are you going to do?";
        Choice c1 = new Choice("return home", Action.GoToBase);
        Choice c2 = new Choice("get registration certificate", Action.AddToInventory, "Registration Certificate");
        this.currentChoices.add(c1);
        this.currentChoices.add(c2);

    }




}
