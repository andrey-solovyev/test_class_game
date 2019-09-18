package com.company.Field;


import javafx.scene.paint.Color;

public class Cell {
    private Color cell_color;
    private boolean shot;
    private int x,y;
// cell other size

    public Cell(int x, int y) {
        this.x=x;
        this.y=y;
        this.cell_color=Color.LIGHTBLUE;
        this.shot=false;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCell_color() {
        return cell_color;
    }

    public void setCell_color(Color cell_color) {
        this.cell_color = cell_color;
    }

    public boolean isShot() {
        return shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }
}
