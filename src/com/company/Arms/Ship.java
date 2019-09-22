package com.company.Arms;

import com.company.Field.Cell;
import javafx.scene.paint.Color;


public class Ship implements Common {

    private int size;
    //where is ship?
    private int healthy;
    private Cell[] ships_cells;
    private boolean vertically;

    public Ship(int size,int x,int y,int dx,int dy,boolean vertically) {
        this.size = size;
        this.ships_cells=new Cell[size];
        this.vertically=vertically;
        paint(ships_cells);
        input(x,y,dx,dy);
    }
    private void input(int x,int y,int dx,int dy){
        healthy=size;
        if (size==1){
            ships_cells[0].setX(x);
            ships_cells[0].setY(y);
        } else {
            ships_cells[0].setX(x);
            ships_cells[0].setY(y);
            ships_cells[size-1].setX(dx);
            ships_cells[size-1].setY(dy);
        }
       for (int i=1;i<ships_cells.length;i++){
           if (x==dx){
               vertically=true;
               ships_cells[i].setX(x);
               ships_cells[i].setY(y+1);
           }
           if (y==dy){
               vertically=false;
               ships_cells[i].setX(x+1);
               ships_cells[i].setY(y);
           }
       }
    }

    public void paint(Cell[] ship){
        for (Cell cell:ship){
            cell.setCell_color(Color.GREEN);
        }
    }
    public boolean check(int x,int y){
       for (int i=0;i<ships_cells.length;i++) {
           if (ships_cells[i].getX()==x && ships_cells[i].getY()==y){
               ships_cells[i].setShot(true);
               return true;
           }
       }
        return false;
    }
    public boolean checkCell(int q){
        if (ships_cells[q].isShot()){
            return true;
        }
        return false;
    }
    public Cell getCell(int q){
        return ships_cells[q];
    }
    public boolean isDead(){
    if (healthy==0){
    return true;
    }return false;
    }

    public boolean isVertically() {
        return vertically;
    }

    public void setVertically(boolean vertically) {
        this.vertically = vertically;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public Cell[] getShips_cells() {
        return ships_cells;
    }

    public void setShips_cells(Cell[] ships_cells) {
        this.ships_cells = ships_cells;
    }
}
