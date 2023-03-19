package battleship_game.gameComponents;

import java.util.ArrayList;

import battleship_game.observ.ObservableBoard;
import battleship_game.observ.ObservableShip;
import battleship_game.observ.ShipObserver;


/**
 * A player's board that holds information about the current state
 */
public class Board extends ObservableBoard implements ShipObserver {
    
    protected Cell[][] grid = new Cell[10][10];
    protected ArrayList<Ship> ships = new ArrayList<>();
    protected boolean[] addedShips = new boolean[6];
    private String player;

    /**
     * The constructor creates the board with cells
     * @param player The player to whom the board belongs
     */
    public Board(String player){

        this.player = player;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                grid[i][j] = new Cell(i, j);
            }
        }

        for (int i = 0; i < addedShips.length; i++) {
            addedShips[i] = false;
        }
    }


    /**
     * Tells the board which cell got shot at
     * @param x x coordinate of the cell
     * @param y y coordinate of the cell
     * @return The new status of the cell that got hit
     */
    public CellStatus shotAt(int x, int y){
        return grid[x][y].isHit();
    }


    /**
     * Checks if a set of coordinates is available for a ship placement
     * @param coordinates The set of coordinates
     * @return True if available
     */
    public boolean checkPlacement(int[][] coordinates){

        if(addedShips[coordinates.length]){
            return false;
        }

        int x;
        int y;

        for(int[] coordinate : coordinates){
            x = coordinate[0];
            y = coordinate[1];
            
            if(x>9 || y>9){
                return false;
            }
            if(grid[x][y].getStatus() != CellStatus.EMPTY){
                return false;
            }
        }

        return true;
    }

    /**
     * Adds a ship on the provided coordinates
     * @param coordinates The coordinates on which to place the ship
     */
    public void addShip(int[][] coordinates){
        
        int x;
        int y;
        ArrayList<Cell> cells = new ArrayList<>();
        
        for(int[] coordinate : coordinates){
            x = coordinate[0];
            y = coordinate[1];
            
            cells.add(grid[x][y]);
        }

        Ship ship = new Ship(cells);
        ship.addObserver(this);
        ships.add(ship);
        addedShips[coordinates.length] = true;
    }


    /**
     * Notifies the board that a ship was sunk
     * @param ship The ship that was sunk
     */
    @Override
    public void update(ObservableShip ship) {
        
        ships.remove(ship);

        if(ships.size() == 0){
            notifyLost(player);
        }
    }


    /**
     * Get the ships
     * @return An arraylist with the ships
     */
    public ArrayList<Ship> getShips(){
        return ships;
    }

    /**
     * Get the board grid
     * @return a 2-D array with the Cells
     */
    public Cell[][] getGrid(){
        return grid;
    }

    /**
     * Returns the list that make sure only one ship per size is added
     * @return The list used to make the checks
     */
    public boolean[] getAddedShips(){
        return addedShips;
    }
}