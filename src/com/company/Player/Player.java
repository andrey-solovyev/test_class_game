package com.company.Player;

import com.company.Field.Cell;

public interface Player {
    boolean hit(Cell cell);
    boolean isSubarineMineOrMinesweeper(Cell cell);
    boolean isSubmarine(Cell cell);
    boolean isMine(Cell cell);
    boolean isMineswepeer(Cell cell);
   // void addCellIfцMine(Cell cell);
    Cell whereShot();
    Cell randomPointShip();
    void addCellShip(Cell cell);
    void addMineCell(Cell cell);
    Cell giveMineCell();
    boolean allShipIsDead();

}
