package com.company.AllLogic;


import com.company.Field.Cell;
import com.company.Player.Robot;
import com.company.Player.User;

import java.util.Random;

public class LogicGame {
    private  Game games;
    private boolean haveUser=false;
    private boolean userOneGo=false;
   //выбор игроков
    //if (robot vs robot then...) another robot vs user
   public static void main(String[] args) {
       // write your code here
       System.out.println("Check robot vs user(1),or no(2)");
   }
   private void who(){
       if (haveUser){
           Game game=new Game(new User(),new Robot());
           games=game;
           firstHit();
       }
       else{
           Game game=new Game(new Robot(),new Robot());
           games=game;
           firstHit();
       }
   }
   private void firstHit(){
       int i=new Random().nextInt(2);
       if (i==1){
           userOneGo=true;
       }
   }
   private void move(){
       if (userOneGo && haveUser ){
     Cell cell= games.getUser().whereShot();
           if (games.getRobot().hit(cell)){
               if (games.getRobot().isSubarineMineOrMinesweeper(cell)){

               }
           }
       }
   }

}