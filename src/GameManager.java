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
        this.hicl = new HICLocation();
        this.el = new EmbassyLocation();
        this.unil = new UniLocation();
//        THLocation testth = new THLocation();
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(this.thl);
        locations.add(this.el);
        locations.add(this.unil);
        locations.add(this.hicl);
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
        text = text.strip().toLowerCase();
        Inventory playerInventory = this.p.getPlayerInventory();

        if (text.equals("help")) {
            currentLocation.getChoices();
            return;
        }

        Choice choiceSelected = currentLocation.getChoiceSelected(text);
        System.out.println("choice selected: " + text);
        if (text.equals("quit")) {
            this.gameStatus = false;
            System.out.println("Quitting....");
            return;
        }


        if (playerInventory.checkIfDone()) {
            this.gameStatus = false;
            System.out.println("YOU HAVE WON!!!");
            return;
        }

        if (this.days - 8 == 0) {
            this.gameStatus = false;
            System.out.println("YOU HAVE FAILED!");
            return;
        }

        if (choiceSelected.type.equals("goToBase")) {
            this.currentLocation = this.bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.type.equals("wait")) {
            currentLocation.update(choiceSelected, this.days);
            this.currentLocation = this.bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.type.equals("addToInventory")) {
            Inventory inv = this.p.getPlayerInventory();
            inv.addToInventory(choiceSelected.item);
            Choice currentLocationChoice = this.bl.getChoiceSelected(currentLocation.getLocationName().strip().toLowerCase());
            bl.removeFromChoices(currentLocationChoice);
            this.currentLocation = bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.type.equals("goToLocation")) {
//            currentLocation.update(choiceSelected, this.days);
            this.currentLocation = choiceSelected.location;
            System.out.println("you are now at: " + currentLocation.getLocationName());
        }
    }

    public void run() {
        if (currentLocation instanceof LocationUpdatable) {
            currentLocation.update(this.days);
        }
        int daysLeft = 8 - this.days;
        System.out.println("Days left: " + daysLeft );
        String textEntered = tp.printDialog(currentLocation.getCurrentDialog());
        if (textEntered.strip().equals("quit")){
            this.gameStatus = false;
            return;
        }
        this.parseText(textEntered);
    }


}
