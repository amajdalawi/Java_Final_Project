/**
 * This enum is a list of actions a certain choice can belong to. The game manager will use this enum
 * to check the action to be done.
 */
public enum Action {
    /**
     * Action representing going back to the baseLocation
     */
    GoToBase,
    /**
     * Action representing going to a certain location
     */
    GoToLocation,
    /**
     * action representing waiting for a certain event to happen
     */
    Wait,
    /**
     * Action representing  adding an item to inventory
     */
    AddToInventory
}
