package battleship_game.gameComponents;

import java.util.ArrayList;

import battleship_game.observ.CellObserver;
import battleship_game.observ.ObservableCell;
import battleship_game.observ.ObservableShip;

/**
 * A representation of a ship using Cells
 */
public class Ship extends ObservableShip implements CellObserver{
    
    private ArrayList<Cell> cells = new ArrayList<>();

    /**
     * Builds the ship
     * @param cells The cells that the ship consists off
     */
    public Ship(ArrayList<Cell> cells) {
        this.cells = cells;

        for(Cell cell : cells){
            cell.setStatus(CellStatus.ALIVE);
            cell.addObserver(this);
        }
    }

    /**
     * gets the ship's cells
     * @return An ArrayList of the cells
     */
    public ArrayList<Cell> getCells(){
        return cells;
    }


    /**
     * Notifies the ship that a Cell in it got hit
     * @param cell The cell that got hit
     */
    @Override
    public void update(ObservableCell cell) {

        cells.remove(cell);

        if(cells.size() == 0){
            notifySunk();
        }
    }
}
