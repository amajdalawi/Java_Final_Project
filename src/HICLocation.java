import java.util.ArrayList;

public class HICLocation extends Location {

    public HICLocation() {
        this.locationName = "Health Insurance Company";
    }
    @Override
    public String getCurrentDialog() {
        return null;
    }

    @Override
    public void update(int days) {

    }

    @Override
    public void update(Choice choice, int days) {

    }

    @Override
    public ArrayList<Choice> getCurrentChoices() {
        return null;
    }

    @Override
    public void getChoices() {

    }
    // Health Insurance Company Location
}
