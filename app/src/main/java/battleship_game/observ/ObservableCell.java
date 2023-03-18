package battleship_game.observ;

import java.util.ArrayList;

public class ObservableCell {
    
    protected ArrayList<CellObserver> observers = new ArrayList<>();


    public void addObserver(CellObserver observer){
        observers.add(observer);
    }
     
    public void removeObserver(CellObserver observer){
        observers.remove(observer);
    }

    public void notifyHit(){
        for(CellObserver observer : observers){
            observer.update(this);
        }
    }
}