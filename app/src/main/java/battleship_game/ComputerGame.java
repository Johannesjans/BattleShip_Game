package battleship_game;

import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.CellStatus;
import battleship_game.gameComponents.Computer;
import battleship_game.observ.BoardObserver;
import battleship_game.uiComponents.BoardView;
import battleship_game.uiComponents.SetupBoardView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ComputerGame extends Scene implements BoardObserver{
    
    VBox layout;

    BoardView computBoardView;
    int currentTurn = 1;
    Board playerBoard;
    Board computerBoard;
    SetupBoardView playerBoardView;
    Computer computer;
    App app;


    public ComputerGame(App app, Board playerBoard, Board computerBoard, SetupBoardView playerBoardView){

        super(new VBox(5), 500, 780);
        this.app = app;
        this.playerBoard = playerBoard;
        this.computerBoard = computerBoard;
        this.playerBoardView = playerBoardView;
        playerBoard.addObserver(this);
        computerBoard.addObserver(this);
        computer = new Computer();

        layout = (VBox) getRoot();
        layout.setStyle("-fx-background-color: rgb(42, 42, 42);");
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(15,30, 45, 30));
        layout.setSpacing(20);

        Label title = new Label("Enemy waters");
        title.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 25pt; -fx-text-fill: white;");
        computBoardView = new BoardView(this, computerBoard);

        playerBoardView.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(title, computBoardView, playerBoardView);
    }


    public void tryCell(int x, int y){

        if(currentTurn == 1){
            CellStatus originalState = computerBoard.getGrid()[x][y].getStatus();
            CellStatus result = computerBoard.shotAt(x, y);
            computBoardView.paintCell(result, x, y);

            if(originalState == CellStatus.EMPTY){
                computerTurn();
            }
        }

        else{
            CellStatus originalState = playerBoard.getGrid()[x][y].getStatus();
            CellStatus result = playerBoard.shotAt(x, y);
            playerBoardView.paintCell(result, x, y);

            if(originalState == CellStatus.ALIVE){
                computer.hit(x, y);
                computerTurn();
            }
            else{
                computer.miss(x, y);
                currentTurn = 1;
            }
        }
    }


    public void computerTurn(){
        currentTurn = 2;
        int[] guess = new int[2];
        guess = computer.newGuess();
        tryCell(guess[0], guess[1]);
    }


    @Override
    public void update(String player) {
        app.endGame(player);
    }
}
