package battleship_game.gameComponents;

import java.util.ArrayList;

import battleship_game.observ.ObservableShip;
import battleship_game.observ.ShipObserver;

public class Board implements ShipObserver {
    
    private Cell[][] grid = new Cell[10][10];
    private ArrayList<Ship> ships = new ArrayList<>();

    public Board(){
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                grid[i][j] = new Cell(i, j);
            }
        }
    }


    public void shotAt(int x, int y){
        grid[x][y].isHit();
    }


    public boolean checkPlacement(int[][] coordinates){

        int x;
        int y;

        for(int[] coordinate : coordinates){
            x = coordinate[0];
            y = coordinate[1];
            
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
    }


    @Override
    public void update(ObservableShip ship) {
        
        ships.remove(ship);

        if(ships.size() == 0){
            //GAMEOVER
        }
    }


    public ArrayList<Ship> getShips(){
        return ships;
    }


    public Cell[][] getGrid(){
        return grid;
    }
}