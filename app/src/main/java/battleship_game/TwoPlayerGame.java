package battleship_game;

import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.CellStatus;
import battleship_game.observ.BoardObserver;
import battleship_game.uiComponents.BoardView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * The "Engine" for the two-player game
 */
public class TwoPlayerGame extends Scene implements BoardObserver{
    
    VBox layout;
    VBox player1view;
    VBox player2view;
    BoardView player1boardView;
    BoardView player2boardView;
    int currentTurn = 1;
    Board player1board;
    Board player2board;
    App app;

    /**
     * Builds the game
     * @param app A reference to the app where the game is running
     * @param playerOne The board of player 1
     * @param playerTwo The board of player 2
     */
    public TwoPlayerGame(App app, Board playerOne, Board playerTwo){

        super(new VBox(5), 650, 500);
        this.app = app;
        
        player1board = playerOne;
        player1board.addObserver(this);
        player2board = playerTwo;
        player2board.addObserver(this);

        layout = (VBox) getRoot();
        layout.setStyle("-fx-background-color: rgb(42, 42, 42);");
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Label title1 = new Label("Player 1, Make your move");
        title1.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 20pt; -fx-text-fill: white;");
        player1boardView = new BoardView(this, player2board);

        player1view = new VBox();
        player1view.setAlignment(Pos.CENTER);
        player1view.setSpacing(25);
        player1view.getChildren().addAll(title1, player1boardView);

        Label title2 = new Label("Player 2, Make your move");
        title2.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 20pt; -fx-text-fill: white;");
        player2boardView = new BoardView(this, player1board);

        player2view = new VBox();
        player2view.setAlignment(Pos.CENTER);
        player2view.setSpacing(25);
        player2view.getChildren().addAll(title2, player2boardView);

        layout.getChildren().add(player1view);
    }

    /**
     * Simulates a shot on a cell. Also detirmines if the current player gets to shoot again or not
     * @param x The x coordinate of the shot
     * @param y THe y coordinate of the shot
     */
    public void tryCell(int x, int y){
        CellStatus originalState;
        CellStatus result;
        
        if(currentTurn == 1){
            originalState = player2board.getGrid()[x][y].getStatus();
            result = player2board.shotAt(x, y);
            player1boardView.paintCell(result, x, y);
        }
        else{
            originalState = player1board.getGrid()[x][y].getStatus();
            result = player1board.shotAt(x, y);
            player2boardView.paintCell(result, x, y);
        }

        if(originalState == CellStatus.EMPTY){
            nextPlayer();
        }
    }

    
    /**
     * Makes nessecary changes to let next player make its shot
     */
    public void nextPlayer(){
        
        layout.getChildren().remove(0);

        if(currentTurn == 1){
            currentTurn = 2;
            layout.getChildren().add(player2view);
        }
        else{
            currentTurn = 1;
            layout.getChildren().add(player1view);
        }
    }

    /**
     * A method to let the game know that a player has lost
     * @param player The player who lost
     */
    @Override
    public void update(String player) {
        app.endGame(player);
    }
}