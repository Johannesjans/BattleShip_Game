package battleship_game.observ;

import java.util.ArrayList;

/**
 * Makes the Cell observable. Keeps a list of its obervers
 */
public class ObservableCell {
    
    protected ArrayList<CellObserver> observers = new ArrayList<>();

    /**
     * Adds an oberver to the object
     * @param observer The observer to add
     */
    public void addObserver(CellObserver observer){
        observers.add(observer);
    }
    
    /**
     * Removes an oberver from the object
     * @param observer The observer to remove
     */
    public void removeObserver(CellObserver observer){
        observers.remove(observer);
    }

    /**
     * Notifies the observers that the cell got hit
     */
    public void notifyHit(){
        for(CellObserver observer : observers){
            observer.update(this);
        }
    }
}