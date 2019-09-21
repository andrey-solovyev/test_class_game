package com.company.Player;

import com.company.AllLogic.Game;
import com.company.Arms.Arms;
import com.company.Field.Cell;
import com.company.Field.Game_field;
import javafx.scene.paint.Color;

public class User implements Player{
    private Arms arms;
    private Game_field game_field;

    public User() {
    }
    @Override
    public boolean hit(Cell cell){
        return arms.hit(cell.getX(),cell.getY());
    }
    public void colorShotShip(Cell cell){
        game_field.getGame_field()[cell.getX()][cell.getY()].setCell_color(Color.RED);
            }

    public Arms getArms() {
        return arms;
    }

    public void setArms(Arms arms) {
        this.arms = arms;
    }

    public Game_field getGame_field() {
        return game_field;
    }

    public void setGame_field(Game_field game_field) {
        this.game_field = game_field;
    }
}
