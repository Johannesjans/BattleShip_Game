package battleship_game;

import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.ComputerBoard;
import battleship_game.uiComponents.EndScene;
import battleship_game.uiComponents.SetupBoardView;
import battleship_game.uiComponents.SetupScene;
import battleship_game.uiComponents.StartScene;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application{

    private Stage primaryStage;
    private Board player1Board;
    private Board player2Board;
    private ComputerBoard computerBoard;
    private SetupBoardView boardView;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        userChoice();
    }

    
    public void userChoice(){
        StartScene startScene = new StartScene(this);

        primaryStage.setScene(startScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void player1Setup(){
        SetupScene player1 = new SetupScene(this, "Player 1");
        primaryStage.setScene(player1);
    }


    public void player2Setup(){
        SetupScene player2 = new SetupScene(this, "Player 2");
        primaryStage.setScene(player2);
    }


    public void startTwoPlayer(){
        TwoPlayerGame game = new TwoPlayerGame(this, player1Board, player2Board);
        primaryStage.setScene(game);
    }


    public void setupComputerGame(){
        SetupScene player = new SetupScene(this, "");
        primaryStage.setScene(player);
    }


    public void startComputerGame(){
        ComputerBoard newComputerBoard = new ComputerBoard("Computer");
        computerBoard = newComputerBoard;

        ComputerGame computerGame = new ComputerGame(this, player1Board, computerBoard, boardView);
        primaryStage.setScene(computerGame);
    }


    public void endGame(String player){
        EndScene endScene = new EndScene(this, player);
        primaryStage.setScene(endScene);
    }


    public void setPlayer1Board(Board board){
        player1Board = board;
    }


    public void setPlayer2Board(Board board){
        player2Board = board;
    }


    public void setBoardView(SetupBoardView boardView){
        this.boardView = boardView;
    }
}