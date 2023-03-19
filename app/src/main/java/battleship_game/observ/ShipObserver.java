package battleship_game.observ;

/**
 * Interface used by a board to get notified when a ship has sunk
 */
public interface ShipObserver {
    
    /**
     * Method that acts on the information
     * @param object The ship that has sunk
     */
    public void update(ObservableShip object);
}
