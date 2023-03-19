package battleship_game.observ;

import java.util.ArrayList;

/**
 * Makes the board observable. Keeps a list if its observers
 */
public class ObservableBoard {
    
    protected ArrayList<BoardObserver> observers = new ArrayList<>();

    /**
     * Adds an oberver to the object
     * @param observer The observer to add
     */
    public void addObserver(BoardObserver observer){
        observers.add(observer);
    }
     
    /**
     * Removes an oberver from the object
     * @param observer The observer to remove
     */
    public void removeObserver(BoardObserver observer){
        observers.remove(observer);
    }

    /**
     * Notifies the observers that the player lost
     * @param player The player that lost
     */
    public void notifyLost(String player){
        for(BoardObserver observer : observers){
            observer.update(player);
        }
    }
}