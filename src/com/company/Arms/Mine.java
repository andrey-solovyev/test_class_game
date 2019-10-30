package com.company.Arms;

import com.company.Field.Cell;
import javafx.scene.paint.Color;


public class Mine implements Common  {
    private Cell Mine;
    private boolean isDead=true;
    public Mine(int x, int y) {
        this.Mine=new Cell(x,y);
        Mine.setCell_color(Color.YELLOW);
    }

    public Cell getMine() {
        return Mine;
    }

    public void setMine(Cell mine) {
        Mine = mine;
    }


    @Override
    public boolean check(int x, int y) {
        if (Mine.getX()==x && Mine.getY()==y){
            isDead=true;
            return true;
        }
        return false;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }
}
