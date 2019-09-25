package com.company.AllLogic;


import com.company.Field.Cell;
import com.company.Player.Player;
import com.company.Player.Robot;
import com.company.Player.User;

import java.util.Random;

public class LogicGame {
    private Game games;
    private boolean haveUser = false;
    private boolean playerOneGo = false;
    private boolean playerTwoGo = false;
    private Player playerOne;
    private Player playerTwo;

    //выбор игроков
    //if (robot vs robot then...) another robot vs user
    public static void main(String[] args) {
        // write your code here
        System.out.println("Check robot vs user(1),or no(2)");
    }

    private void who() {
        if (haveUser) {

            Game game = new Game(new User(), new Robot());
            playerOne = game.getUser();
            playerTwo = game.getRobot();
            games = game;
            firstHit();
        } else {
            Game game = new Game(new Robot(), new Robot());
            playerOne = game.getRobot();
            playerTwo = game.getRoborTwo();
            games = game;
            firstHit();
        }
    }

    private void firstHit() {
        int i = new Random().nextInt(2);
        if (i == 1) {
            playerOneGo = true;
        } else {
            playerTwoGo = true;
        }
    }

    private void WhoIsmove() {
        if (playerOneGo) {
            Cell cell = playerOne.whereShot();
            checkShot(playerOne, playerTwo, cell);
        } else if (playerTwoGo) {
            checkShot(playerTwo, playerOne, playerTwo.whereShot());
        }
    }

    private void checkShot(Player One, Player Two, Cell cell) {
        if (Two.hit(cell)) {
            if (Two.isSubarineMineOrMinesweeper(cell)) {
                notShip(One, Two, cell);
            } else {
                if (!Two.allShipIsDead()){
                    WhoIsmove();
                } else {
                    finish();
                }

            }
        }
    }

private void finish(){
        if (playerOneGo){
            System.out.println("ONE IS WIN");
        } else {
            System.out.println("TWO IF WIN");
        }

}

    public void notShip(Player one, Player two, Cell cell) {
        if (two.isMine(cell)) {
            two.addCellShip(one.randomPointShip());
            if (playerOneGo){
                playerOneGo=false;
                playerTwoGo=true;
            } else {
                playerOneGo=true;
                playerTwoGo=false;
            }
            WhoIsmove();
        } else if (two.isSubmarine(cell)) {
            if (playerOneGo){
                playerOneGo=false;
                playerTwoGo=true;
            } else {
                playerOneGo=true;
                playerTwoGo=false;
            }
           checkShot(two,one,cell);
        } else if (two.isMineswepeer(cell)) {
            two.addMineCell(one.giveMineCell());
            if (playerOneGo){
                playerOneGo=false;
                playerTwoGo=true;
            } else {
                playerOneGo=true;
                playerTwoGo=false;
            }
        }
    }

}