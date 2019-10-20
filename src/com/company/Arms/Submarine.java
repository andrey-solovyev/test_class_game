package com.company.Arms;

import com.company.Field.Cell;
import javafx.scene.paint.Color;

import java.awt.*;

public class Submarine implements Common{
    private Cell submarine;
    private boolean healthy=true;
    public Submarine( int x, int y) {
        this.submarine = new Cell(x,y);

        submarine.setCell_color(Color.YELLOW);
    }

    public Cell getSubmarine() {
        return submarine;
    }

    public void setSubmarine(Cell submarine) {
        this.submarine = submarine;
    }

    @Override
    public boolean check(int x, int y) {
        if (submarine.getX()==x && submarine.getY()==y){

            return true;
        }
        return false;
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
