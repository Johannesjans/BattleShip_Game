package battleship_game.uiComponents;

import battleship_game.gameComponents.Board;
import battleship_game.gameComponents.CellStatus;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * A Vizualisation of a board, used to place the ships. Used together with the PiecesView in a SetupScene.
 * Also used in the ComputerGame to represent the players own board.
 */
public class SetupBoardView extends GridPane{
    
    int rows;
    int columns;

    /**
     * Builds the visuals and the functionality of the board
     * @param setupScene The scene in which this view is used
     * @param board The board to represent
     */
    public SetupBoardView(SetupScene setupScene, Board board){
        
        rows = board.getGrid().length;
        columns = board.getGrid().length;

        EventHandler<MouseEvent> cellClickHandler = event -> {
            Rectangle cell = (Rectangle) event.getSource();
            int x = GridPane.getColumnIndex(cell);
            int y = GridPane.getRowIndex(cell);
            
            setupScene.placeShip(x, y);
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


    /**
     * Color the cells where a ship is placed
     * @param coordinates Coordinates for the cells
     */
    public void fillCells(int[][] coordinates){
        for (int[] coordinate : coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];

            for (Node node : getChildren()) {
                if (GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
                    ((Rectangle) node).setFill(Color.BLACK);
                    break;
                }
            }
        }
    }

    
    /**
     * Paints a specific cell after it has been hit
     * @param status The status of the cell to be repainted
     * @param x The x coordinate of the cell
     * @param y The y coordinate of the cell
     */
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