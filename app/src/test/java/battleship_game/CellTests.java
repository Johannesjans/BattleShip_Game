package battleship_game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import battleship_game.gameComponents.Cell;
import battleship_game.gameComponents.CellStatus;

public class CellTests {
    
    @Test void fields(){

        Cell cell = new Cell(4, 7);

        assertEquals(4, cell.getX());
        assertEquals(7, cell.getY());
        assertEquals(CellStatus.EMPTY, cell.getStatus());

        cell.setStatus(CellStatus.ALIVE);
        assertEquals(CellStatus.ALIVE, cell.getStatus());

    }


    @Test void isHit(){

        Cell cell = new Cell(1,5);
        assertEquals(CellStatus.EMPTY, cell.getStatus());
        
        cell.isHit();
        assertEquals(CellStatus.MISSED, cell.getStatus());
    }
}