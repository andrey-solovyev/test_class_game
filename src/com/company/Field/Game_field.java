package com.company.Field;

import javafx.scene.paint.Color;

public class Game_field {
    private Cell[][] game_field = new Cell[10][10];

    public Game_field() {
        for (int i = 0; i < game_field.length; i++) {
            for (int k = 0; k < game_field.length; k++) {
                game_field[i][k] = new Cell(i, k);
                game_field[i][k].setShot(false);
                game_field[i][k].setCell_color(Color.BLUE);
            }
        }
    }

    public Cell[][] getGame_field() {

        return game_field;
    }

    public void setGame_field(Cell[][] game_field) {
        this.game_field = game_field;
    }

    private boolean check(int x, int y) {
        if (game_field[x][y].isShot()) {
            return true;
        }
        return false;
    }
}
