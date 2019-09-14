package com.company.Field;

public class Game_field extends Cell {
private Cell[][] game_field=new Cell[10][10];

    public Game_field() {
        this.game_field = game_field;
    }

    public Cell[][] getGame_field() {
        return game_field;
    }

    public void setGame_field(Cell[][] game_field) {
        this.game_field = game_field;
    }
    private boolean check(int x,int y){
        if (game_field[x][y].isShot()){
            return true;
        }
        return false;
    }
}
