import java.util.ArrayList;

public class Inventory {
    private ArrayList<String> Items;

    public Inventory() {
        Items = new ArrayList<>();
    }

    public void addToInventory(String item) {
        this.Items.add(item);
    }

    public boolean checkIfDone(){
        return this.Items.contains("Annex 100")
                && this.Items.contains("Birth Certificate")
                && this.Items.contains("Health Insurance")
                && this.Items.contains("Registration Certificate");
    }
}
