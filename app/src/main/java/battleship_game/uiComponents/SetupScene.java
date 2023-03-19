package battleship_game.uiComponents;

import battleship_game.App;
import battleship_game.gameComponents.Board;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;


public class SetupScene extends Scene{
    
    private VBox layout = new VBox();
    private Board board;
    private int selectedShip;
    private boolean horizontal = true; 
    private SetupBoardView boardView;
    private PiecesView piecesView;
    private HBox boardAndPieces;

    public SetupScene(App app, String player) {

        super(new VBox(20), 650, 500);

        layout = (VBox) getRoot();
        layout.setStyle("-fx-background-color: rgb(42, 42, 42);");
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Label title = new Label(player + " Place your ships");
        title.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 30pt; -fx-text-fill: white;");
        
        board = new Board(player);
        boardView = new SetupBoardView(this, board); 
        piecesView = new PiecesView(this);

        boardAndPieces = new HBox();
        boardAndPieces.setSpacing(30);
        boardAndPieces.getChildren().addAll(boardView, piecesView);

        HBox buttons = new HBox();
        buttons.setSpacing(35);
        buttons.setAlignment(Pos.CENTER);

        Button resetB = new Button("Reset");
        resetB.setPrefWidth(130);
        resetB.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 13pt; -fx-text-fill: rgb(42, 42, 42); -fx-focus-traversable: false;");
        
        resetB.setOnAction(e -> {

            boardAndPieces = (HBox) layout.getChildren().get(1);
            boardAndPieces.getChildren().remove(boardView);
            boardAndPieces.getChildren().remove(piecesView);

            board = new Board(player);
            boardView = new SetupBoardView(this, board);
            piecesView = new PiecesView(this);
            boardAndPieces.getChildren().addAll(boardView, piecesView);
        });

        Button continueB = new Button("Continue");
        continueB.setPrefWidth(130);
        continueB.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 13pt; -fx-text-fill: rgb(42, 42, 42); -fx-focus-traversable: false;");
        
        continueB.setOnAction(e -> {
            switch(player){
                case "Player 1":
                    app.setPlayer1Board(board);
                    app.player2Setup();
                    break;

                case "Player 2":
                    app.setPlayer2Board(board);
                    app.startTwoPlayer();
                    break;

                case "":
                    app.setPlayer1Board(board);
                    app.setBoardView(boardView);
                    app.startComputerGame();
                    break;
            }
        });

        buttons.getChildren().addAll(resetB, continueB);
        layout.getChildren().addAll(title, boardAndPieces, buttons);
    }

    public void setSelectedShip(int size){
        selectedShip = size;
    }

    public void setHorizontal (boolean horizontal){
        this.horizontal = horizontal;
    }


    public void placeShip(int x, int y){
        
        if(selectedShip>1){
            int[][] shipCoordinates = new int[selectedShip][2];

            if(horizontal){
                for(int i=0; i<selectedShip; i++){
                    shipCoordinates[i][0] = x+i;
                    shipCoordinates[i][1] = y;
                }
            }

            else{
                for(int i=0; i<selectedShip; i++){
                    shipCoordinates[i][0] = x;
                    shipCoordinates[i][1] = y+i;
                }
            }

            boolean okPlacement = board.checkPlacement(shipCoordinates);

            if(okPlacement){
                board.addShip(shipCoordinates);
                boardView.fillCells(shipCoordinates);
                selectedShip = 0;
            }
        }
    }
}
