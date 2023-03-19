package battleship_game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.Cell;
import battleship_game.gameComponents.CellStatus;

public class BoardTests {
    

    @Test void constructor(){
        
        Board board = new Board("Test");
        boolean[] addedShips = board.getAddedShips();

        assertTrue(addedShips.length == 6);
        
        for(boolean check : addedShips){
            assertFalse(check);
        }

        Cell[][] grid = board.getGrid();
        assertEquals(CellStatus.EMPTY, grid[0][0].getStatus());
        assertEquals(CellStatus.EMPTY, grid[0][9].getStatus());
        assertEquals(CellStatus.EMPTY, grid[9][0].getStatus());
        assertEquals(CellStatus.EMPTY, grid[9][9].getStatus());
        assertEquals(CellStatus.EMPTY, grid[5][5].getStatus());
    }


    @Test void checkAndAddShips(){

        Board board = new Board("Test");
        int[][] coordinates1 = {{2,1}, {2,2}, {2,3}};
        int[][] coordinates2 = {{4,3}, {4,4}, {4,5}, {4,6}, {4,7}};

        board.addShip(coordinates1);
        board.addShip(coordinates2);

        boolean[] addedShips = board.getAddedShips();
        assertTrue(addedShips[3]);
        assertTrue(addedShips[5]);

        int[][] try1 = {{2,4}, {2,5}, {2,6}};
        int[][] try2 = {{2,5}, {2,6}};
        int[][] try3 = {{2,7}, {2,8}, {2,9}, {2, 10}};
        int[][] try4 = {{4,3}, {5,3}, {6,3}, {7, 3}};

        assertFalse(board.checkPlacement(try1));
        assertTrue(board.checkPlacement(try2));
        assertFalse(board.checkPlacement(try3));
        assertFalse(board.checkPlacement(try4));
    }
}
