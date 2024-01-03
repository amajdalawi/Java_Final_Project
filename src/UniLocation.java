import java.util.ArrayList;

public class UniLocation extends  Location {

    public UniLocation() {
        this.locationName = "University";
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
}
