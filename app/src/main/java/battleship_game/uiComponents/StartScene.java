package battleship_game.uiComponents;

import battleship_game.App;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartScene extends Scene{
    VBox layout = new VBox();
 


    public StartScene(App app) {

        super(new VBox(20), 600, 450);

        layout = (VBox) getRoot();
        layout.setStyle("-fx-background-color: rgb(42, 42, 42);");
        layout.setAlignment(Pos.CENTER);

        Label title = new Label("Battleships");
        title.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 48pt; -fx-text-fill: white;");

        Button vsComputer = new Button("Play vs Computer");
        vsComputer.setPrefWidth(170);
        vsComputer.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 11pt; -fx-text-fill: rgb(42, 42, 42); -fx-padding: 10; -fx-focus-traversable: false;");
        
        Button twoPlayer = new Button("2-player Game");
        twoPlayer.setPrefWidth(170);
        twoPlayer.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 11pt; -fx-text-fill: rgb(42, 42, 42); -fx-padding: 10; -fx-focus-traversable: false;");
        
        
        vsComputer.setOnAction(e -> {

        });
        twoPlayer.setOnAction(e -> {
            app.player1Setup();
        });

        layout.getChildren().addAll(title, vsComputer, twoPlayer);
    }
}
