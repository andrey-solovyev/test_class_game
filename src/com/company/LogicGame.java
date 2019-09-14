package com.company;

import com.company.Arms.Arms;
import com.company.Field.Game_field;

import java.util.ArrayList;

public class LogicGame {
    private Arms my_arms;

    private Game_field shot_my_field = new Game_field();
    private Game_field robot = new Game_field();

    //i need 4 game_field two for me and two for robot
    private void create_field() {


    }

    //it is check, are you shot or no??? i need X,Y and check on double array
    private boolean check_Shot(int x, int y, Arms arms) {
//step one, check
        if (arms.hit(x, y)) {
            return true;
        }
        return false;
    }
}
private void act(int x,int y,Arms arms){
    if (arms.getMine().check(x,y)){

    }
}
