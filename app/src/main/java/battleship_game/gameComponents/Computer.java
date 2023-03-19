package battleship_game.gameComponents;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The AI that plays agains the player
 */
public class Computer {
    
    private Cell[][] grid = new Cell[10][10];
    private int[] destroyed;

    /**
     * Creates a grid that is used by the computer to make "smart" moves
     */
    public Computer(){
 
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                grid[i][j] = new Cell(i, j);
            }
        }

    }

    /**
     * Lets the computer know it missed its last shot
     * @param x x coordinate of the shot
     * @param y y coordinate of the shot
     */
    public void miss(int x, int y){
        grid[x][y].setStatus(CellStatus.MISSED);
    }

    /**
     * Lets the computer know it missed its last show
     * @param x x coordinate of the shot
     * @param y y coordinate of the shot
     */
    public void hit(int x, int y){
        destroyed = new int[2];
        destroyed[0] = x;
        destroyed[1] = y;
        grid[x][y].setStatus(CellStatus.DESTROYED);
    }

    /**
     * Decides what coordinates to guess next. tries adjacent if there was a recent hit and random otherwise
     * @return The coordinates of the new guess
     */
    public int[] newGuess(){
        int[] guess = new int[2];
        
        if(destroyed != null){
            guess = getAdjacent(destroyed);

            if(guess != null){
                return guess;
            }
            else{
                destroyed = null;
                guess = new int[2];
            }
        }

        do{
            guess[0] = ThreadLocalRandom.current().nextInt(0,10);
            guess[1] = ThreadLocalRandom.current().nextInt(0,10);

        } while(grid[guess[0]][guess[1]].getStatus() != CellStatus.EMPTY);

        return guess;
    }

    /**
     * Checks if Cells adjacent to the last hit are viable guesses
     * @param destroyed Coordinates of the last hit
     * @return Coordinates of an adjacent cell. Null if no adjacent cells are qualified
     */
    public int[] getAdjacent(int[] destroyed){
        int[] adjacent = new int[2];

        if(destroyed[0]<9){
            if (grid[destroyed[0]+1][destroyed[1]].getStatus() == CellStatus.EMPTY){
                adjacent[0] = destroyed[0]+1;
                adjacent[1] = destroyed[1];
                return adjacent;
            }
        }
        if(destroyed[0]>0){ 
            if(grid[destroyed[0]-1][destroyed[1]].getStatus() == CellStatus.EMPTY){
                adjacent[0] = destroyed[0]-1;
                adjacent[1] = destroyed[1];
                return adjacent;
            }
        }
        if(destroyed[1]<9){
            if(grid[destroyed[0]][destroyed[1]+1].getStatus() == CellStatus.EMPTY){
                adjacent[0] = destroyed[0];
                adjacent[1] = destroyed[1]+1;
                return adjacent;
            }
        }
        if(destroyed[1]>0){
            if(grid[destroyed[0]][destroyed[1]-1].getStatus() == CellStatus.EMPTY){
                adjacent[0] = destroyed[0];
                adjacent[1] = destroyed[1]-1;
                return adjacent;
            }
        }

        return null;
    }

    /**
     * Get the grid
     * @return The grid
     */
    public Cell[][] getGrid(){
        return grid;
    }
}