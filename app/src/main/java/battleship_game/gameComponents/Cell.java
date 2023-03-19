package battleship_game.gameComponents;

import battleship_game.observ.ObservableCell;

public class Cell extends ObservableCell{
    
    private CellStatus status;
    private int x;
    private int y;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        status = CellStatus.EMPTY;
    }
    

    public void setStatus(CellStatus status){
        this.status = status;
    }

    
    public CellStatus getStatus(){
        return status;
    }


    public int getX(){
        return x;
    }
    

    public int getY(){
        return y;
    }


    public CellStatus isHit(){

        if(status == CellStatus.ALIVE){
            status = CellStatus.DESTROYED;
            notifyHit();
        }
        else if(status == CellStatus.EMPTY){
            status = CellStatus.MISSED;
        }
        
        return status;
    }
}