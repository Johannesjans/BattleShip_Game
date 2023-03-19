package battleship_game.gameComponents;

import java.util.ArrayList;

import battleship_game.observ.ObservableBoard;
import battleship_game.observ.ObservableShip;
import battleship_game.observ.ShipObserver;

public class Board extends ObservableBoard implements ShipObserver {
    
    private Cell[][] grid = new Cell[10][10];
    private ArrayList<Ship> ships = new ArrayList<>();
    private boolean[] addedShips = new boolean[6];
    private String player;

    public Board(String player){

        this.player = player;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                grid[i][j] = new Cell(i, j);
            }
        }

        for(boolean addedShip : addedShips){
            addedShip = false;
        }
    }


    public CellStatus shotAt(int x, int y){
        return grid[x][y].isHit();
    }


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


    @Override
    public void update(ObservableShip ship) {
        
        ships.remove(ship);

        if(ships.size() == 0){
            notifyLost(player);
        }
    }


    public ArrayList<Ship> getShips(){
        return ships;
    }


    public Cell[][] getGrid(){
        return grid;
    }
}