package com.company.AllLogic;

import com.company.Field.Cell;
import com.company.Field.Game_field;

import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private boolean go=false;
    private ArrayList<Cell> queue=new ArrayList<>();
    private Game_field robotShot=new Game_field();
    public void whereShot(){
        if (queue.isEmpty()){
            randomShot();
        } else {
        }
    }
    private Cell randomShot(){
        boolean shot=true;
        Random random=new Random();
        while (shot){
            int i=random.nextInt(10);
            int k=random.nextInt(10);
            Cell cell=new Cell(i,k);
        if (!cell.isShot()){
            return cell;
        }
        }
        return null;
    }
    private

}
