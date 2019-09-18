package com.company.Arms;

import com.company.Field.Cell;

import java.awt.*;
import java.util.Random;

public class Arms {
    private Ship ship_4;
    private Ship ship_3_1;
    private Ship ship_3_2;
    private Ship ship_2_1;
    private Ship ship_2_2;
    private Ship ship_2_3;
    private Ship ship_1_1;
    private Ship ship_1_2;
    private Ship ship_1_3;
    private Ship ship_1_4;
    private Mine mine;
    private Submarine submarine;
    private Ship[] ships;


    public Arms(Ship ship_4, Ship ship_3_1, Ship ship_3_2, Ship ship_2_1, Ship ship_2_2, Ship ship_2_3, Ship ship_1_1, Ship ship_1_2, Ship ship_1_3, Ship ship_1_4, Mine mine, Submarine submarine) {
        this.ship_4 = ship_4;
        this.ship_3_1 = ship_3_1;
        this.ship_3_2 = ship_3_2;
        this.ship_2_1 = ship_2_1;
        this.ship_2_2 = ship_2_2;
        this.ship_2_3 = ship_2_3;
        this.ship_1_1 = ship_1_1;
        this.ship_1_2 = ship_1_2;
        this.ship_1_3 = ship_1_3;
        this.ship_1_4 = ship_1_4;
        this.mine = mine;
        this.submarine = submarine;
        getAllShip();
    }

    public void getAllShip() {
        Ship [] ship=new Ship[10];
        ship[0]=ship_4;
        ship[1]=ship_3_1;
        ship[2]=ship_3_2;
        ship[3]=ship_2_1;
        ship[4]=ship_2_2;
        ship[5]=ship_2_3;
        ship[6]=ship_1_1;
        ship[7]=ship_1_2;
        ship[8]=ship_1_3;
        ship[9]=ship_1_4;
ships=ship;    }


    public Common[] getArms(){
        return AllArms();
}
    private Common[] AllArms(){
        Common[] objects=new Common[12];
        objects[0]=ship_4;
        objects[1]=ship_3_1;
        objects[2]=ship_3_2;
        objects[3]=ship_2_1;
        objects[4]=ship_2_2;
        objects[5]=ship_2_3;
        objects[6]=ship_1_1;
        objects[7]=ship_1_2;
        objects[8]=ship_1_3;
        objects[9]=ship_1_4;
        objects[10]=submarine;
        objects[11]=mine;
        return objects;
    }
public boolean hit(int x,int y){
        return isHit(x,y);
}
private boolean isHit(int x,int y){
        for (int i=0;i<getArms().length;i++){
           if (getArms()[i].check(x,y)){
               return true;
           }
        }
        return false;
}
public boolean isMineOrSubmarine(int x,int y){
        if (getArms()[11].check(x,y) || getArms()[10].check(x,y)){
            return true;
        }
        return true;
}
public boolean isSubmarine(int x,int y){
        if (getArms()[10].check(x,y)){
            return true;
        }
        return false;
}
private Cell randomPoint() {
    boolean check = true;
    Random random = new Random();
    while (check) {
        int i = random.nextInt(10);
        if (!ships[i].isDead()) {
            int q = random.nextInt(ships[i].getSize());
            if (ships[i].checkCell(q)) {
                check = false;
                return ships[i].getCell(q);

            }
        }

    }
    return null;
}


    public Ship getShip_4() {
        return ship_4;
    }

    public void setShip_4(Ship ship_4) {
        this.ship_4 = ship_4;
    }

    public Ship getShip_3_1() {
        return ship_3_1;
    }

    public void setShip_3_1(Ship ship_3_1) {
        this.ship_3_1 = ship_3_1;
    }

    public Ship getShip_3_2() {
        return ship_3_2;
    }

    public void setShip_3_2(Ship ship_3_2) {
        this.ship_3_2 = ship_3_2;
    }

    public Ship getShip_2_1() {
        return ship_2_1;
    }

    public void setShip_2_1(Ship ship_2_1) {
        this.ship_2_1 = ship_2_1;
    }

    public Ship getShip_2_2() {
        return ship_2_2;
    }

    public void setShip_2_2(Ship ship_2_2) {
        this.ship_2_2 = ship_2_2;
    }

    public Ship getShip_2_3() {
        return ship_2_3;
    }

    public void setShip_2_3(Ship ship_2_3) {
        this.ship_2_3 = ship_2_3;
    }

    public Ship getShip_1_1() {
        return ship_1_1;
    }

    public void setShip_1_1(Ship ship_1_1) {
        this.ship_1_1 = ship_1_1;
    }

    public Ship getShip_1_2() {
        return ship_1_2;
    }

    public void setShip_1_2(Ship ship_1_2) {
        this.ship_1_2 = ship_1_2;
    }

    public Ship getShip_1_3() {
        return ship_1_3;
    }

    public void setShip_1_3(Ship ship_1_3) {
        this.ship_1_3 = ship_1_3;
    }

    public Ship getShip_1_4() {
        return ship_1_4;
    }

    public void setShip_1_4(Ship ship_1_4) {
        this.ship_1_4 = ship_1_4;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public Submarine getSubmarine() {
        return submarine;
    }

    public void setSubmarine(Submarine submarine) {
        this.submarine = submarine;
    }
}
