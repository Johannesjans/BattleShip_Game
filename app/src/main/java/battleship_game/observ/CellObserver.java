package battleship_game.observ;

import battleship_game.gameComponents.Cell;
import battleship_game.gameComponents.CellStatus;

public interface CellObserver {
    
    public void update(ObservableCell object, CellStatus status);
}
