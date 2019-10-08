package com.company.Arms;

import com.company.Field.Cell;
import javafx.scene.paint.Color;


public class Ship implements Common {

    private int size;
    //where is ship?
    private int healthy;
    private Cell[] ships_cells;
    private boolean vertically;

    public Ship(int size, int x, int y, int dx, int dy, boolean vertically) {
        this.size = size;
        this.vertically = vertically;
        //paint(ships_cells);
        this.ships_cells=new Cell[size];
        input(x, y, dx, dy);
    }

    private void input(int x, int y, int dx, int dy) {
        healthy = size;
        if (size == 1) {
            ships_cells[0]=new Cell(x,y);
        } else {
           ships_cells[0]=new Cell(x,y);
           ships_cells[size-1]=new Cell(dx,dy);
           if (x==dx){
               vertically=false;
           } else {
               vertically=true;
           }
        }
        for (int i = 1; i < ships_cells.length; i++) {
            if (!vertically) {
                ships_cells[i]=new Cell(x,++y);

            }
            if (vertically) {
              ships_cells[i]=new Cell(++x,y);
            }
        }

    }


    public boolean check(int x, int y) {
        for (int i = 0; i < ships_cells.length; i++) {
            if (ships_cells[i].getX() == x && ships_cells[i].getY() == y) {
                ships_cells[i].setShot(true);
                healthy=-1;
                return true;
            }
        }
        return false;
    }

    public boolean checkCell(int q) {
        if (ships_cells[q].isShot()) {
            return true;
        }
        return false;
    }

    public Cell getCell(int q) {
        return ships_cells[q];
    }

    public boolean isDead() {
        for (int i = 0; i < ships_cells.length; i++) {
            if (ships_cells[i].isShot()){
                continue;
            } else {
                return false;
            }
        }
        return true;
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
