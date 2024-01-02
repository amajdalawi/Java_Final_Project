public class Main {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        while (gm.getGameStatus())
        {
            gm.run();
        }
    }
}
