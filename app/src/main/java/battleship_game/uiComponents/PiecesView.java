package battleship_game.uiComponents;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PiecesView extends VBox{
    
    boolean horizontal = true;

    public PiecesView(SetupScene setupScene){

        this.setSpacing(15);
        this.setPadding(new Insets(25));

        EventHandler<MouseEvent> cellClickHandler = event -> {
            Rectangle cell = (Rectangle) event.getSource();
            GridPane parent = (GridPane)cell.getParent();
            int shipSize = parent.getColumnCount();
            
            selectShip(parent);
            setupScene.setSelectedShip(shipSize);
        };


        for(int i=2; i<6; i++){

            GridPane ship = new GridPane();

            for(int j=0; j<i; j++){
            
                Rectangle cell = new Rectangle();
                cell.setWidth(30);
                cell.setHeight(30);
                cell.setStroke(Color.BLACK);
                cell.setStrokeWidth(0.5);
                cell.setOnMouseClicked(cellClickHandler);
                cell.setFill(Color.GRAY);
                ship.add(cell, j, 0);
            }

            this.getChildren().add(ship);
        }


        VBox setCenter = new VBox();
        setCenter.setAlignment(Pos.CENTER);
        setCenter.setSpacing(15);

        Label orientation = new Label("Horizontal");
        orientation.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 15pt; -fx-text-fill: white;");
        orientation.setAlignment(Pos.CENTER);

        Button changeOrientation = new Button("Rotate");
        changeOrientation.setPrefWidth(130);
        changeOrientation.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 11pt; -fx-text-fill: rgb(42, 42, 42); -fx-focus-traversable: false;");
        
        changeOrientation.setOnAction(e -> {
            
            if(horizontal == true){
                horizontal = false;
                ((Label) setCenter.getChildren().get(0)).setText("Vertical");
            } else {
                horizontal = true;
                ((Label) setCenter.getChildren().get(0)).setText("Horizontal");
            }
                    
            setupScene.setHorizontal(horizontal);
        });

        setCenter.getChildren().addAll(orientation, changeOrientation);

        this.getChildren().add(setCenter);
    }


    public void selectShip(GridPane ship){

        for(Node node : ship.getChildren()){
            Rectangle curCell = (Rectangle) node;
            curCell.setFill(Color.BLACK);
        }

        for(int i=0; i<4; i++){
            
            GridPane curShip = (GridPane) this.getChildren().get(i);
            if(curShip != ship){
                
                for(Node node : curShip.getChildren()){
                    Rectangle curCell = (Rectangle) node;
                    curCell.setFill(Color.GRAY);
                }
            }
        }
    }
}