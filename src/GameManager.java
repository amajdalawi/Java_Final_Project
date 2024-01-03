import java.util.ArrayList;

public class GameManager {
    private int days;
    private ArrayList<Location> listOfLocations;
    private boolean gameStatus;
    private Player p;
    private Location currentLocation;
    private FirstLocation fl;
    private UniLocation unil;
    private HICLocation hicl;
    private EmbassyLocation el;
    private THLocation thl;
    private BaseLocation bl;
    private TextPrinter tp;
    public GameManager() {
        this.gameStatus = true;
        this.p = new Player();
        this.tp = new TextPrinter();
        this.fl = new FirstLocation();
        this.bl = new BaseLocation();
        this.currentLocation = fl;
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public void parseText(String text) {
        Choice choiceSelected = currentLocation.getChoiceSelected(text);
        System.out.println("choice selected: " + text);
        if (text.strip().equals("quit")) {
            this.gameStatus = false;
            return;
        }

        if (choiceSelected.type.equals("addToInventory")) {
            Inventory inv = this.p.getPlayerInventory();
            inv.addToInventory(choiceSelected.item);
            this.currentLocation = bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.type.equals("goToLocation")) {
            currentLocation.update(choiceSelected, this.days);
            this.currentLocation = choiceSelected.location;

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
