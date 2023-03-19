package battleship_game.uiComponents;


import battleship_game.TwoPlayerGame;
import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.CellStatus;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView extends GridPane{
    
    int rows;
    int columns;

    public BoardView(TwoPlayerGame game, Board board){
            
        rows = board.getGrid().length;
        columns = board.getGrid().length;

        EventHandler<MouseEvent> cellClickHandler = event -> {
            Rectangle cell = (Rectangle) event.getSource();
            int x = GridPane.getColumnIndex(cell);
            int y = GridPane.getRowIndex(cell);
            game.tryCell(x, y);
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

        this.setAlignment(Pos.CENTER);
    }

    
    public void paintCell(CellStatus status, int x, int y){
        
        Rectangle cell = new Rectangle();
        
        for (Node node : getChildren()) {
            if (GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
                cell = (Rectangle) node;
                break;
            }
        }

        if(status == CellStatus.DESTROYED){
            cell.setFill(Color.rgb(175, 0, 42));
        }
        else{
            cell.setFill(Color.rgb(0, 51, 102));
        }
    }
}