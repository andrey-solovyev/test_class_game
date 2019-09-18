package com.company.AllLogic;

import com.company.Player.Robot;
import com.company.Player.User;

public class Game {
    private boolean gameFirstPlayer=false;
    private boolean gameSecondPlayer=false;

    private User user;
    private Robot robot;
    private Robot roborTwo;

    public Game(User user, Robot robot) {
        this.user = user;
        this.robot = robot;
    }

    public Game(Robot robot, Robot roborTwo) {
        this.robot = robot;
        this.roborTwo = roborTwo;
    }

}
