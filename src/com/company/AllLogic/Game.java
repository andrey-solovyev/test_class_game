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
        robot.fieldShip();
    }

    public Game(Robot robot, Robot roborTwo) {
        this.robot = robot;
        this.roborTwo = roborTwo;
        roborTwo.fieldShip();
        robot.fieldShip();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Robot getRoborTwo() {
        return roborTwo;
    }

    public void setRoborTwo(Robot roborTwo) {
        this.roborTwo = roborTwo;
    }
}
