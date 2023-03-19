package battleship_game.gameComponents;

import java.util.concurrent.ThreadLocalRandom;

/**
 * An extension of the board cladd that places the computer's ships
 */
public class ComputerBoard extends Board{
    
    /**
     * Builds the board
     * @param player The player to whom the board belongs
     */
    public ComputerBoard(String player){

        super(player);
        addShips();
    }

    /**
     * Adds the different sized ships to the board
     */
    public void addShips(){

        int randX;
        int randY;
        int randOrientation;

        //The different ship sizes
        for(int i=2; i<6; i++){

            //Keep trying new placements until the ship is created
            while(!addedShips[i]){
                
                int[][] coordinates = new int[i][2];
                randX = ThreadLocalRandom.current().nextInt(0,11);
                randY = ThreadLocalRandom.current().nextInt(0,11);
                randOrientation = ThreadLocalRandom.current().nextInt(0,2);
                
                if(randOrientation == 0){
                    for(int j=0; j<i; j++){
                        coordinates[j][0] = randX + j;
                        coordinates[j][1] = randY;
                    }
                }
                else{
                    for(int j=0; j<i; j++){
                        coordinates[j][0] = randX;
                        coordinates[j][1] = randY + j;
                    }
                }

                if(checkPlacement(coordinates)){
                    addShip(coordinates);
                }
            }
        }
    }
}