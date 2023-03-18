package battleship_game.observ;

import java.util.ArrayList;

public class ObservableShip {
    
    protected ArrayList<ShipObserver> observers = new ArrayList<>();


    public void addObserver(ShipObserver observer){
        observers.add(observer);
    }
     
    public void removeObserver(ShipObserver observer){
        observers.remove(observer);
    }

    public void notifySunk(){
        for(ShipObserver observer : observers){
            observer.update(this);
        }
    }
}