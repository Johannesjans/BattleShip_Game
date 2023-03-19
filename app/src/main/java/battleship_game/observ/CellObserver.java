package battleship_game.observ;

/**
 * Interface used by the ships to get notified when a cell is hit 
 */
public interface CellObserver {
    
    /**
     * Method that acts on the information
     * @param object The cell that got hit
     */
    public void update(ObservableCell object);
}
