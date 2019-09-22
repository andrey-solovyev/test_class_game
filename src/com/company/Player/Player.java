package com.company.Player;

import com.company.Field.Cell;

public interface Player {
    boolean hit(Cell cell);
    boolean isSubarineMineOrMinesweeper(Cell cell);
    boolean isSubmarin(Cell cell);
    boolean isMine(Cell cell);
    boolean isMineswepeer(Cell cell);
   // void addCellIfцMine(Cell cell);
    Cell whereShot();

}
