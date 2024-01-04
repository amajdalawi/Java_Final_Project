import java.util.ArrayList;

/**
 * Class representing the location of the embassy
 */
public class EmbassyLocation extends  Location {
//    private ArrayList<Choice> currentChoices;
//    private String currentDialogue;
//    private String locationName;

    public EmbassyLocation() {
        this.currentChoices = new ArrayList<Choice>();
        this.currentDialogue = "You are now at the Embassy, what are you going to do?";
        this.locationName = "Embassy";
        Choice c1 = new Choice("return home", Action.GoToBase);
        Choice c2 = new Choice("get birth certificate", Action.AddToInventory, "Birth Certificate");
        this.currentChoices.add(c1);
        this.currentChoices.add(c2);

    }




}
