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
    private boolean playerOneLastShot=false;
    private boolean playerTwoLastShot=false;
    private Player playerOne;
    private Player playerTwo;

    //выбор игроков
    //if (robot vs robot then...) another robot vs user


    public LogicGame() {
    }

    public void who() {
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
            WhoIsmove();
        } else {
            playerTwoGo = true;
            WhoIsmove();
        }
    }

    /* private void WhoIsmove() {
         if (playerOneGo) {
             Cell cell = playerOne.whereShot();
             System.out.println("One"+cell.getX()+" " +cell.getY());
           if (checkShot(playerOne, playerTwo, cell) && !playerTwo.allShipIsDead()){
               WhoIsmove();
           } else {
               if (playerTwo.allShipIsDead()){
                   finish();
               } else {
                   redefinition();
                   WhoIsmove();
                   }
           }
         } else if (playerTwoGo) {
             Cell cell = playerTwo.whereShot();
             System.out.println("Two"+cell.getX()+" " +cell.getY());

             if ( checkShot(playerTwo, playerOne, cell) && !playerTwo.allShipIsDead()){
                 WhoIsmove();
             } else {
                 if (playerOne.allShipIsDead()){
                     finish();
                 } else {
                     redefinition();
                     WhoIsmove();
                 }
             }
         }
     }*/
    private void WhoIsmove() {
        while (!playerOne.allShipIsDead() && !playerTwo.allShipIsDead()) {
            if (playerOneGo) {
                Cell cell = playerOne.whereShot(playerOneLastShot);
                System.out.println("One " + cell.getX() + " " + cell.getY());
                checkShot(playerOne, playerTwo, cell);
            }else if (playerTwoGo) {
                Cell cell = playerTwo.whereShot(playerTwoLastShot);
                System.out.println("Two"+cell.getX()+" " +cell.getY());
                checkShot( playerTwo,playerOne, cell);
            }
        }
        finish();
    }


    private void checkShot(Player One, Player Two, Cell cell) {
        if (Two.hit(cell)) {
            if (Two.isSubarineMineOrMinesweeper(cell)) {
                notShip(One, Two, cell);
            }
            One.giveDeadShip(Two.isDeadShip(cell));
            if (playerOneGo){
                playerOneLastShot=true;
                playerTwoLastShot=false;
            } else if(playerTwoGo){
                playerTwoLastShot=true;
                playerOneLastShot=false;
            }
        } else {
            redefinition();
        }
    }


    private void finish() {
        if (playerOneGo) {
            System.out.println("ONE IS WIN");
        } else {
            System.out.println("TWO IF WIN");
        }

    }

    public void notShip(Player one, Player two, Cell cell) {
        if (two.isMine(cell)) {
            two.addCellShip(one.randomPointShip());
            redefinition();
        } else if (two.isSubmarine(cell)) {
            redefinition();
            checkShot(two, one, cell);
        } else if (two.isMineswepeer(cell)) {
            redefinition();
            two.addMineCell(one.giveMineCell());

        }
    }

    private void redefinition() {
        if (playerOneGo) {
            playerOneGo = false;
            playerTwoGo = true;
        } else {
            playerOneGo = true;
            playerTwoGo = false;
        }
    }

}