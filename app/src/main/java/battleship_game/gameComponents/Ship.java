package battleship_game.gameComponents;

import java.util.ArrayList;

import battleship_game.observ.CellObserver;
import battleship_game.observ.ObservableCell;
import battleship_game.observ.ObservableShip;

public class Ship extends ObservableShip implements CellObserver{
    
    private ArrayList<Cell> cells = new ArrayList<>();

    
    public Ship(ArrayList<Cell> cells) {
        this.cells = cells;

        for(Cell cell : cells){
            cell.setStatus(CellStatus.ALIVE);
            cell.addObserver(this);
        }
    }


    public ArrayList<Cell> getCells(){
        return cells;
    }


    @Override
    public void update(ObservableCell cell) {

        cells.remove(cell);

        if(cells.size() == 0){
            notifySunk();
        }
    }
}
