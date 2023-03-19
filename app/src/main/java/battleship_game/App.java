package battleship_game;

import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.ComputerBoard;
import battleship_game.uiComponents.EndScene;
import battleship_game.uiComponents.SetupBoardView;
import battleship_game.uiComponents.SetupScene;
import battleship_game.uiComponents.StartScene;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class of the project 
 */
public class App extends Application{

    private Stage primaryStage;
    private Board player1Board;
    private Board player2Board;
    private ComputerBoard computerBoard;
    private SetupBoardView boardView;

    /**
     * The main method
     * @param args Potential arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the application
     * @param primaryStage The primary stage of the application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        userChoice();
    }

    /**
     * Sets the first scene of the game and waits for a user choice
     */
    public void userChoice(){
        StartScene startScene = new StartScene(this);

        primaryStage.setScene(startScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Changes scene to the player 1 setup
     */
    public void player1Setup(){
        SetupScene player1 = new SetupScene(this, "Player 1");
        primaryStage.setScene(player1);
    }

    /**
     * Changes scene to the player 2 setup
     */
    public void player2Setup(){
        SetupScene player2 = new SetupScene(this, "Player 2");
        primaryStage.setScene(player2);
    }

    /**
     * Starts the two player game and changes the scene
     */
    public void startTwoPlayer(){
        TwoPlayerGame game = new TwoPlayerGame(this, player1Board, player2Board);
        primaryStage.setScene(game);
    }

    /**
     * Changes scene to the player setup
     */
    public void setupComputerGame(){
        SetupScene player = new SetupScene(this, "");
        primaryStage.setScene(player);
    }

    /**
     * Initializes the computer board, starts the computer game and changes the scene
     */
    public void startComputerGame(){
        ComputerBoard newComputerBoard = new ComputerBoard("Computer");
        computerBoard = newComputerBoard;

        ComputerGame computerGame = new ComputerGame(this, player1Board, computerBoard, boardView);
        primaryStage.setScene(computerGame);
    }

    /**
     * Sets the scene to display the winner
     * @param player The player that lost
     */
    public void endGame(String player){
        EndScene endScene = new EndScene(this, player);
        primaryStage.setScene(endScene);
    }

    /**
     * Sets the board for player 1
     * @param board The player's board
     */
    public void setPlayer1Board(Board board){
        player1Board = board;
    }

    /**
     * Sets the board for player 2
     * @param board The player's board
     */
    public void setPlayer2Board(Board board){
        player2Board = board;
    }

    /**
     * Sets the boardView for a computerGame
     * @param boardView The boardView
     */
    public void setBoardView(SetupBoardView boardView){
        this.boardView = boardView;
    }
}