/**
 * Interface that represents a location that can update its own state
 */
public interface LocationUpdatable {
    /**
     * init a days variable of type int inside the inherited location instance
     * @param days - days passed since the start of the game
     */
    public  void update(int days);

    /**
     * updates the location's internal state
     * @param choice - choice instance to check against
     * @param days - days passed since start of game
     */
    public void update(Choice choice ,int days);
}
