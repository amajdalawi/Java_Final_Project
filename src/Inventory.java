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

    public void printInventory() {
        if (this.Items.size() == 0) {
            System.out.println("There's nothing in the inventory");
        } else {
            System.out.println("Inside inventory");
            for (String i: this.Items) {
                System.out.println(i);
            }
        }
    }
}
