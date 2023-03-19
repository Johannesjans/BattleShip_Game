package battleship_game.gameComponents;

import battleship_game.observ.ObservableCell;

/**
 * A component that is used to build the boards
 */
public class Cell extends ObservableCell{
    
    private CellStatus status;
    private int x;
    private int y;

    /**
     * Constructor
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        status = CellStatus.EMPTY;
    }
    
    /**
     * Changes the status of the cell
     * @param status The new status
     */
    public void setStatus(CellStatus status){
        this.status = status;
    }

    /**
     * Get the status of the cell
     * @return The cell status
     */
    public CellStatus getStatus(){
        return status;
    }

    /**
     * Get the x coordinate
     * @return The x coordinate
     */
    public int getX(){
        return x;
    }
    
    /**
     * Get the y coordinate
     * @return The y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * Tells the cell it got hit and return the new status
     * @return The new CellStatus
     */
    public CellStatus isHit(){

        if(status == CellStatus.ALIVE){
            status = CellStatus.DESTROYED;
            notifyHit();
        }
        else if(status == CellStatus.EMPTY){
            status = CellStatus.MISSED;
        }
        
        return status;
    }
}