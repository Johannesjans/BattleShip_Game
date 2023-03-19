package battleship_game.observ;

import java.util.ArrayList;

public class ObservableBoard {
    
    protected ArrayList<BoardObserver> observers = new ArrayList<>();


    public void addObserver(BoardObserver observer){
        observers.add(observer);
    }
     
    public void removeObserver(BoardObserver observer){
        observers.remove(observer);
    }

    public void notifyLost(String player){
        for(BoardObserver observer : observers){
            observer.update(this, player);
        }
    }
}
