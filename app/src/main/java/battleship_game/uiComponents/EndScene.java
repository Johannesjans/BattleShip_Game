package battleship_game.uiComponents;

import battleship_game.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EndScene extends Scene{

    VBox layout = new VBox();

    
    public EndScene(App app, String player) {

        super(new VBox(20), 650, 500);

        layout = (VBox) getRoot();
        layout.setStyle("-fx-background-color: rgb(42, 42, 42);");
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setSpacing(20);

        Label title = new Label("Winner");
        title.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 50pt; -fx-text-fill: white;");

        Label subTitle = new Label("Player 1");
        subTitle.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 32pt; -fx-text-fill: white;");

        if(player.equals("Player 1")){
            subTitle.setText("Player 2");
        }
        else if(player.equals("")){
            subTitle.setText("Computer");
        }

        Button playAgain = new Button("Play Again");
        playAgain.setPrefWidth(170);
        playAgain.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12pt; -fx-text-fill: rgb(42, 42, 42); -fx-padding: 10; -fx-focus-traversable: false;");

        playAgain.setOnAction(e -> {
            app.setPlayer1Board(null);
            app.setPlayer2Board(null);
            app.userChoice();
        });

        layout.getChildren().addAll(title, subTitle, playAgain);
    }
}