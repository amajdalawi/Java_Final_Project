import java.util.ArrayList;

public class GameManager {
    private int days;
    private ArrayList<Location> listOfLocations;
    private boolean gameStatus;
    private Location currentLocation;
    private TextPrinter tp;
    public GameManager() {
        this.gameStatus = true;
        Player p = new Player();
        this.tp = new TextPrinter();
        FirstLocation fl = new FirstLocation();
        this.currentLocation = fl;



    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public void parseText(String text) {
        System.out.println(text);
        if (text.strip().equals("quit")) {
            this.gameStatus = false;
        }
    }

    public void run() {
        String textEntered = tp.printDialog(currentLocation.getCurrentDialog());
        this.parseText(textEntered);
    }


}
