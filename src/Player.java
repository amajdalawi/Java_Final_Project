public class Player {
    Inventory playerInventory;

    public Player() {
        this.playerInventory = new Inventory();
    }
    public Inventory getPlayerInventory() {
        return playerInventory;
    }
}
