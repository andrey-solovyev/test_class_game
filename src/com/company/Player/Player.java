package com.company.Player;

import com.company.Field.Cell;

public interface Player {
    boolean hit(Cell cell);
    boolean isSubarineMineOrMinesweeper(Cell cell);
}
