public class Choice {
    String type;
    String item;
    String textRep;
    public Choice(String textRep,String type, String item) {
        this.item = item;
        this.textRep = textRep;
        this.type = type;
    }

    public String toString() {
        return this.textRep;
    }

}
