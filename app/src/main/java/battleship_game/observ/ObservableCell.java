package battleship_game.gameComponents;

import java.util.ArrayList;

public class ObservableCell {
    
    protected ArrayList<CellObserver> observers = new ArrayList<>();


    public void addObserver(CellObserver observer){
        observers.add(observer);
    }
     
    public void removeObserver(CellObserver observer){
        observers.remove(observer);
    }

}