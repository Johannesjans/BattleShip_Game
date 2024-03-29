package battleship_game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import battleship_game.gameComponents.*;
import java.util.ArrayList;

public class ShipTests {
    
    int [][] shipCoordinates = {{4,6}, {2,5}, {6,7}};
    ArrayList<Cell> cells = new ArrayList<>();
    Cell cell1;
    Cell cell2;
    Cell cell3;


    public ShipTests(){

        cell1 = new Cell(shipCoordinates[0][0], shipCoordinates[0][1]);
        cell2 = new Cell(shipCoordinates[1][0], shipCoordinates[1][1]);
        cell3 = new Cell(shipCoordinates[2][0], shipCoordinates[2][1]);

        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
    }

    @Test void constructor(){

        Ship ship = new Ship(cells);

        assertEquals(CellStatus.ALIVE, ship.getCells().get(1).getStatus());
    }


    @Test void update(){
        Board board = new Board("Player 1,");
        board.addShip(shipCoordinates);
        
        Cell[][] grid = board.getGrid();
        Ship ship = board.getShips().get(0);

        assertTrue(ship.getCells().size() == 3);

        //simulating a hit on the ship
        ship.update(grid[shipCoordinates[0][0]][shipCoordinates[0][1]]);
        assertTrue(ship.getCells().size() == 2);
        assertEquals(grid[shipCoordinates[1][0]][shipCoordinates[1][1]], ship.getCells().get(0));

        //simulating sinnking the ship
        assertTrue(board.getShips().size() == 1);
        ship.update(grid[shipCoordinates[1][0]][shipCoordinates[1][1]]);
        ship.update(grid[shipCoordinates[2][0]][shipCoordinates[2][1]]);
        assertTrue(board.getShips().size() == 0);
    }
}
