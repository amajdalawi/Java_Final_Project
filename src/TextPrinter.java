import java.util.Scanner;

/**
 * class that prints the dialogue, to be used inside the game manager class
 */
public class TextPrinter {

    /**
     * method that runs the dialogue before input
     * @param Dialog current dialogue of the location.
     * @return String the string to be input
     */
    public String printDialog(String Dialog) {
        System.out.print(Dialog + "\n" + "> ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
