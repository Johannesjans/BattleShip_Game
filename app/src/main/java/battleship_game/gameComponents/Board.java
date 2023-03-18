package battleship_game.gameComponents;

import java.util.ArrayList;

import battleship_game.observ.ObservableShip;
import battleship_game.observ.ShipObserver;

public class Board implements ShipObserver {
    
    Cell[][] grid = new Cell[10][10];
    ArrayList<Ship> ships = new ArrayList<>();

    public Board(){
        
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
        ships.add(ship);
    }

    @Override
    public void update(ObservableShip ship) {
        
        ships.remove(ship);
        ship.removeObserver(this);
        if(ships.size() == 0){
            //GAMEOVER
        }
    }
}