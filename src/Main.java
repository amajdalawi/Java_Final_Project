public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        GameManager gm = new GameManager();
        while (gm.getGameStatus())
        {
            gm.run();
        }
    }
}
