package battleship_game.uiComponents;


import battleship_game.gameComponents.Board;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView extends GridPane{
    
    int rows;
    int columns;

    public BoardView(Board board){
        
        rows = board.getGrid().length;
        columns = board.getGrid().length;

        EventHandler<MouseEvent> cellClickHandler = event -> {
            Rectangle cell = (Rectangle) event.getSource();
            int x = GridPane.getColumnIndex(cell);
            int y = GridPane.getRowIndex(cell);
            
            cell.setFill(Color.BLACK);
            board.shotAt(x, y);
        };

        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Rectangle cell = new Rectangle();
                cell.setWidth(30);
                cell.setHeight(30);
                cell.setStroke(Color.BLACK);
                cell.setStrokeWidth(0.5);
                cell.setOnMouseClicked(cellClickHandler);
                cell.setFill(Color.GRAY);
                add(cell, col, row);
            }
        }
    }
}
