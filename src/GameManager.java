import java.util.ArrayList;

public class GameManager {
    private int days;
    private ArrayList<Location> listOfLocations;
    private boolean gameStatus;
    private Player p;
    private Location currentLocation;
     FirstLocation fl;
     UniLocation unil;
     HICLocation hicl;
     EmbassyLocation el;
     THLocation thl;
     BaseLocation bl;
    private TextPrinter tp;
    public GameManager() {
        this.gameStatus = true;
        this.p = new Player();
        this.tp = new TextPrinter();
        this.fl = new FirstLocation();
        this.thl = new THLocation();
        THLocation testth = new THLocation();
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(this.thl);
//        for (Location l : locations) {
//            System.out.println(l.getCurrentDialog());
//            System.out.println(l.getLocationName());
//        }
        this.bl = new BaseLocation(locations);
        this.currentLocation = bl;
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public void parseText(String text) {
        text = text.strip();
        Choice choiceSelected = currentLocation.getChoiceSelected(text.strip());
        System.out.println("choice selected: " + text);
        if (text.strip().equals("quit")) {
            this.gameStatus = false;
            return;
        }

        if (choiceSelected.type.equals("goToBase")) {
            this.currentLocation = this.bl;
            return;
        }
        if (choiceSelected.type.equals("addToInventory")) {
            Inventory inv = this.p.getPlayerInventory();
            inv.addToInventory(choiceSelected.item);
            bl.removeFromChoices(choiceSelected);
            this.currentLocation = bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.type.equals("goToLocation")) {
            currentLocation.update(choiceSelected, this.days);
            this.currentLocation = choiceSelected.location;
            System.out.println("you are now at: " + currentLocation.locationName);
        }
    }

    public void run() {
        currentLocation.update(this.days);
        String textEntered = tp.printDialog(currentLocation.getCurrentDialog());
        if (textEntered.strip().equals("quit")){
            this.gameStatus = false;
            return;
        }
        this.parseText(textEntered);
    }


}
