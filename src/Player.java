/**
 * Class representing player, to be initialized inside game manager constructor.
 *
 * @author Abdulrahman Almajdalawi
 */
public class Player {
    Inventory playerInventory;

    public Player() {
        this.playerInventory = new Inventory();
    }

    /**
     * Gets inventory of the player
     * @return Inventory returns inventory of the player
     */
    public Inventory getPlayerInventory() {
        return playerInventory;
    }
}
