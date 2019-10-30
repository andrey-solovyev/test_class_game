package com.company.Arms;

import com.company.Field.Cell;
import javafx.scene.paint.Color;

public class Minesweeper implements Common {
    private Cell Mineswepeer;
    private boolean isDead=false;
    public Minesweeper(int x, int y) {
        this.Mineswepeer=new Cell(x,y);
        Mineswepeer.setCell_color(Color.ORANGE);
    }
    @Override
    public boolean check(int x,int y){
        if (Mineswepeer.getX()==x && Mineswepeer.getY()==y){
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
