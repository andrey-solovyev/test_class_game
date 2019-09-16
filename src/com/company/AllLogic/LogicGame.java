package com.company.AllLogic;

import com.company.Arms.Arms;
import com.company.Field.Game_field;

import java.awt.*;


public class LogicGame {
    private Arms arms;
    private Game_field field = new Game_field();
    private Shot shot;


    //i need 4 game_field two for me and two for robot
    private void create_field() {


    }
 public boolean shot(int x,int y){
    if (check_Shot(x,y,arms)){
        return true;
    }
    return false;
    }
//fuck you
    //it is check, are you shot or no??? i need X,Y and check on double array
    private boolean check_Shot(int x, int y, Arms arms) {
//step one, check
        if (arms.hit(x, y)) {
        field.getGame_field()[x][y].setCell_color(Color.RED);
                    return true;
        }
        return false;
    }

private void act(int x,int y,Arms arms){
    if (arms.getMine().check(x,y)){

    }
}
