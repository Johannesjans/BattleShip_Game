package battleship_game;

import battleship_game.uiComponents.SetupScene;
import battleship_game.uiComponents.StartScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application{

    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        StartScene startScene = new StartScene(this);

        primaryStage.setScene(startScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public void twoPlayerGame(){

        SetupScene player1 = new SetupScene(this);
        primaryStage.setScene(player1);
    }
}
