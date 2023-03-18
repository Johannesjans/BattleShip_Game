package battleship_game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application{


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {




        


        VBox mainVbox = new VBox();
        Scene startScene = new Scene(mainVbox, 500,500);

        primaryStage.setScene(startScene);
        primaryStage.show();


    }
}
