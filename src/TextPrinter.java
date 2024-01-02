import java.util.Scanner;

public class TextPrinter {

    public String printDialog(String Dialog) {
        System.out.print(Dialog + "\n" + "> ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
