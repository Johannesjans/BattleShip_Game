package battleship_game.observ;

/**
 * Interfaced used by the games to get notified when a player has lost
 */
public interface BoardObserver {
    
    /**
     * Method to act on the information
     * @param player The player that lost
     */
    public void update(String player);
}