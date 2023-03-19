package battleship_game.observ;

import java.util.ArrayList;

/**
 * Makes the Ship observable. Keeps track of its observers
 */
public class ObservableShip {
    
    protected ArrayList<ShipObserver> observers = new ArrayList<>();

    /**
     * Adds an oberver to the object
     * @param observer The observer to add
     */
    public void addObserver(ShipObserver observer){
        observers.add(observer);
    }
    
    /**
     * Removes an oberver from the object
     * @param observer The observer to remove
     */
    public void removeObserver(ShipObserver observer){
        observers.remove(observer);
    }

    /**
     * Notifies the observer that the ship has sunk
     */
    public void notifySunk(){
        for(ShipObserver observer : observers){
            observer.update(this);
        }
    }
}