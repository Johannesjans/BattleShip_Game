package battleship_game;

import org.junit.jupiter.api.Test;

import battleship_game.gameComponents.Cell;
import battleship_game.gameComponents.CellStatus;
import battleship_game.gameComponents.Computer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ComputerTests {
    

    @Test void contructor(){

        Computer computer = new Computer();

        Cell[][] grid = computer.getGrid();

        assertEquals(CellStatus.EMPTY, grid[5][3].getStatus());
        assertEquals(CellStatus.EMPTY, grid[1][9].getStatus());
        assertEquals(CellStatus.EMPTY, grid[7][0].getStatus());
        assertEquals(CellStatus.EMPTY, grid[7][4].getStatus());
        assertEquals(CellStatus.EMPTY, grid[1][5].getStatus());
    }


    @Test void noDuplicates(){

        Computer computer = new Computer();
        ArrayList<int[]> previous = new ArrayList<>();

        int[] nextCell = new int[2];
        boolean check = false;

        for(int i=0; i<50; i++){
            nextCell = computer.newGuess();

            for(int[] prev : previous){
                check = Arrays.equals(nextCell, prev);
                assertFalse(check);
            }

            computer.miss(nextCell[0], nextCell[1]);
            previous.add(nextCell);
        }

        computer.miss(2,2);
        computer.miss(2,2);
        computer.miss(2,2);
    }


    @Test void getAdjacent(){

        Computer computer = new Computer();
        int[] hit = {5, 5};
        int[] next = new int[2];

        computer.hit(hit[0], hit[1]);
        next = computer.getAdjacent(hit);

        assertTrue(next[0] == hit[0]+1);
        assertTrue(next[1] == hit[1]);

        computer.miss(next[0], next[1]);
        next = computer.getAdjacent(hit);

        assertTrue(next[0] == hit[0]-1);
        assertTrue(next[1] == hit[1]);

        computer.miss(next[0], next[1]);
        next = computer.getAdjacent(hit);

        assertTrue(next[0] == hit[0]);
        assertTrue(next[1] == hit[1]+1);

        computer.miss(next[0], next[1]);
        next = computer.getAdjacent(hit);

        assertTrue(next[0] == hit[0]);
        assertTrue(next[1] == hit[1]-1);
    }
}
