import java.util.ArrayList;

/**
 * Class that controls the game and holds within its lifetime/scope all the
 * locations, player and choices that define the game.
 *
 * @author Abdulrahman Almajdalawi
 */
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

    /**
     * Constructor that initializes objects representing the player, different locations of the game, and the
     * private fields that will be used to control the flow of the game.
     */
    public GameManager() {
        this.gameStatus = true;
        this.days = 0;
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
        this.currentLocation = fl;
    }

    /**
     * returns status of game, if false then the game is over.
     * @return boolean returns the status of the game
     */
    public boolean getGameStatus() {
        return this.gameStatus;
    }


    /**
     * parses the entered text in standard input and does things in the game according to said input
     * @param text entered input in standard input
     */
    public void parseText(String text) {
        text = text.strip().toLowerCase();
        Inventory playerInventory = this.p.getPlayerInventory();

//        if (playerInventory.checkIfDone()) {
//            this.gameStatus = false;
//            System.out.println("YOU HAVE WON!!!");
//            return;
//        }


//        if (!text.equals("help") || !text.equals("inventory") || !text.equals("quit") || !text.equals("quit"))
        if (text.equals("help")) {
            currentLocation.getChoices();
            return;
        }

        if (text.equals("inventory")) {
            Inventory inventory = this.p.getPlayerInventory();
            inventory.printInventory();
            return;
        }


        Choice choiceSelected = currentLocation.getChoiceSelected(text);

        if (choiceSelected == null) {
            System.out.println("you have selected an invalid choice, type help to see the list of available chocies.");
            return;
        }


        System.out.println("choice selected: " + text);
        if (text.equals("quit")) {
            this.gameStatus = false;
            System.out.println("Quitting....");
            return;
        }



        if (this.days - 8 == 0) {
            this.gameStatus = false;
            System.out.println("YOU HAVE FAILED!");
            return;
        }

        if (choiceSelected.getTypeOfAction() == Action.GoToBase) {
            this.currentLocation = this.bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.getTypeOfAction() == Action.Wait) {
            currentLocation.update(choiceSelected, this.days);
            this.currentLocation = this.bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.getTypeOfAction() == Action.AddToInventory) {
            Inventory inv = this.p.getPlayerInventory();
            inv.addToInventory(choiceSelected.item);
            Choice currentLocationChoice = this.bl.getChoiceSelected(currentLocation.getLocationName().strip().toLowerCase());
            bl.removeFromChoices(currentLocationChoice);
            this.currentLocation = bl;
            this.days = this.days + 1;
            return;
        }

        if (choiceSelected.getTypeOfAction() == Action.GoToLocation) {
//            currentLocation.update(choiceSelected, this.days);
            this.currentLocation = choiceSelected.location;
            System.out.println("you are now at: " + currentLocation.getLocationName());
        }


    }

    /**
     * method to be run in a loop in the main method of the game.
     */
    public void run() {

            currentLocation.update(this.days);


        Inventory playerInventory = this.p.getPlayerInventory();

        if (playerInventory.checkIfDone()) {
            this.gameStatus = false;
            System.out.println("YOU HAVE WON!!!");
            return;
        }


        int daysLeft = 8 - this.days;
        System.out.println("Days left: " + daysLeft );
        tp.printDialogue(currentLocation);
        String input = tp.awaitInput();
//        String textEntered = tp.printDialog(currentLocation.getCurrentDialogue());
        if (input.strip().equals("quit")){
            this.gameStatus = false;
            return;
        }
        this.parseText(input);
    }


}
