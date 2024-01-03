public class Choice {
    String type;
    Location location = null;
    String item = null;
    String textRep;
    public Choice(String textRep,String type, String item) {
        this.item = item;
        this.textRep = textRep;
        this.type = type;
    }

    public Choice (String textRep, String type) {
        this.textRep = textRep;
        this.type = type;
    }

    public Choice (String textRep, String type, Location l) {
        this.textRep = textRep;
        this.type = type;
        this.location = l;
    }

    public String toString() {
        return this.textRep;
    }

}
