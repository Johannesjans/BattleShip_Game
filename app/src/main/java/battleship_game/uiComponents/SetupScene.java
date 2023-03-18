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
    private Board board = new Board();
    private int selectedShip;
    private boolean horizontal = true; 

    public SetupScene(App app) {

        super(new VBox(20), 650, 500);

        layout = (VBox) getRoot();
        layout.setStyle("-fx-background-color: rgb(42, 42, 42);");
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Label title = new Label("Place your ships");
        title.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 30pt; -fx-text-fill: white;");
        
        BoardView boardview = new BoardView(board); 
        PiecesView piecesview = new PiecesView(this);

        HBox boardAndPieces = new HBox();
        boardAndPieces.setSpacing(30);
        boardAndPieces.getChildren().addAll(boardview, piecesview);

        HBox buttons = new HBox();
        buttons.setSpacing(35);
        buttons.setAlignment(Pos.CENTER);

        Button resetB = new Button("Reset");
        resetB.setPrefWidth(130);
        resetB.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 13pt; -fx-text-fill: rgb(42, 42, 42); -fx-focus-traversable: false;");
        
        resetB.setOnAction(e -> {

        });

        Button continueB = new Button("Continue");
        continueB.setPrefWidth(130);
        continueB.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 13pt; -fx-text-fill: rgb(42, 42, 42); -fx-focus-traversable: false;");
        
        continueB.setOnAction(e -> {

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
}
