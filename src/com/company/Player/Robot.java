package com.company.Player;

import com.company.Arms.Arms;
import com.company.Arms.Mine;
import com.company.Arms.Minesweeper;
import com.company.Arms.Ship;
import com.company.Arms.Submarine;
import com.company.Field.Cell;
import com.company.Field.Game_field;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Stack;

public class Robot implements Player {
    private boolean go = false;
    private Stack<Cell> queue = new Stack<>();
    private Game_field robotShot = new Game_field();
    private Arms arms;
    private Game_field game_field;
    private Color colorShot = Color.RED;
    private int howMuchShot = 0;//it is for the second shot and other
    private Cell lastShot;

    public Cell whereShot() {
     /*   if (ifHit){
            howMuchShot++;
            if (howMuchShot>=2){
                anotherQueue();
            }
        }*/
        if (!queue.isEmpty()) {
            while (game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].isShot()) {
               lastShot= queue.pop();
            }
            return queue.peek();
        } else {
            return lastShot=randomShot();
        }
    }

    private Cell randomShot() {
        Random random = new Random();
        int i = random.nextInt(10);
        int k = random.nextInt(10);
        lastShot = new Cell(i, k);
        if (lastShot.isShot()) {
            return randomShot();
        }
        return lastShot;
    }


    @Override
    public boolean allShipIsDead(){
        return arms.deadAllShip();
    }
    @Override
    public boolean isSubarineMineOrMinesweeper(Cell cell) {
        if (arms.isMine(cell.getX(), cell.getY())) {
            return true;
        } else if (arms.isSubmarine(cell.getX(), cell.getY())) {
            return true;
        } else return arms.isMineOrSubmarine(cell.getX(), cell.getY());
    }

    @Override
    public boolean hit(Cell cell) {
        return arms.hit(cell.getX(), cell.getY());
    }

    @Override
    public boolean isMine(Cell cell) {
        return arms.isMine(cell.getX(), cell.getY());
    }

    @Override
    public boolean isSubmarine(Cell cell) {
        return arms.isSubmarine(cell.getX(), cell.getY());
    }

    @Override
    public boolean isMineswepeer(Cell cell) {
        return arms.isMineswepeer(cell.getX(), cell.getY());
    }

    @Override
    public Cell giveMineCell() {
        return arms.getMine().getMine();
    }

    @Override
    public void addMineCell(Cell cell) {
        game_field.getGame_field()[cell.getX() - 1][cell.getY() - 1].setShot(true);
    }

    @Override
    public void addCellShip(Cell cell) {
        doQueue(cell.getX(), cell.getY());
    }

    @Override
    public Cell randomPointShip() {
        return arms.randomPoint();
    }
    public void fieldShip(){
        Arms arms1=new Arms(new Ship(4,2,1,6,1,false),(new Ship(3,2,3,4,3,false)),new Ship(3,1,5,1,7,true),new Ship(2,19,1,10,1,true),new Ship(2,18,3,18,4,false),new Ship(2,5,5,5,6,false),new Ship(1,3,20,3,20,false),new Ship(1,18,20,18,20,false),new Ship(1,4,18,4,18,false),new Ship(1,19,17,19,17,false),new Mine(1,1),new Submarine(1,8),new Minesweeper(20,20));
      arms=arms1;
        /*  arms.setShip_4(new Ship(4,2,1,6,1,false));
        arms.setShip_3_1(new Ship(3,2,3,4,3,false));
        arms.setShip_3_2(new Ship(3,1,5,1,7,true));
        arms.setShip_2_1(new Ship(2,19,1,10,1,true));
        arms.setShip_2_2(new Ship(2,18,3,18,4,false));
        arms.setShip_2_3(new Ship(2,5,5,5,6,false));
        arms.setShip_1_1(new Ship(1,3,20,3,20,false));
        arms.setShip_1_2(new Ship(1,18,20,18,20,false));
        arms.setShip_1_3(new Ship(1,4,18,4,18,false));
        arms.setShip_1_4(new Ship(1,19,17,19,17,false));
        arms.setMine(new Mine(1,1));
        arms.setSubmarine(new Submarine(1,8));
        arms.setMinesweeper(new Minesweeper(20,20));
*/
    }

    private void doQueue(int x, int y) {
        if (x + 1 <= 20 && x - 1 >= 1 && y + 1 <= 20 && y - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (x + 1 <= 20 && x - 1 >= 1 && y == 1) {
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (x == 20 && y + 1 <= 20 && y - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (y == 20 && x + 1 <= 20 && x - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x - 1, y));
        } else if (x == 1 && y + 1 <= 20 && y - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
            //we must check cell(20,1),(20,20),(1,20)(1,1)
        } else if (x == 20 && y == 1) {
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (x == 20 && y == 20) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x - 1, y));
        } else if (x == 1 && y == 20) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
        } else if (x == 1 && y == 1) {
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
        }//i do not know! TEST this queue DO NOT REMEMBER
    }

    private void anotherQueue() {
        queue.clear();
        if (lastShot.getX() == this.lastShot.getX()) {
            if (this.lastShot.getY() + 1 != lastShot.getY() && this.lastShot.getY() != 20) {
                queue.push(new Cell(lastShot.getX(), this.lastShot.getY() + 1));
                if (lastShot.getY() != 1) {
                    queue.push(new Cell(lastShot.getX(), lastShot.getY() - 1));
                }
            } else if (this.lastShot.getY() != 1) {
                queue.push(new Cell(lastShot.getX(), this.lastShot.getY() - 1));
                if (lastShot.getY() != 20) {
                    queue.push(new Cell(lastShot.getX(), lastShot.getY() + 1));
                }
            }
        } else if (lastShot.getY() == this.lastShot.getY()) {
            if (this.lastShot.getX() - 1 != lastShot.getX() && this.lastShot.getX() != 1) {
                queue.push(new Cell(this.lastShot.getX() - 1, this.lastShot.getY()));
                if (lastShot.getX() != 20) {
                    queue.push(new Cell(lastShot.getX() + 1, lastShot.getY()));
                }
            } else if (this.lastShot.getX() + 1 != lastShot.getX() && this.lastShot.getX() != 20) {
                queue.push(new Cell(this.lastShot.getX() + 1, this.lastShot.getY()));
                if (lastShot.getX() != 1) {
                    queue.push(new Cell(lastShot.getX() - 1, lastShot.getY()));
                }
            }

        }

    }
}
 /*
            if (lastShot.getY() > doubleShot.getY() && lastShot.getY() != 20) {
                queue.push(new Cell(doubleShot.getX(), lastShot.getY() + 1));

            }
            if (doubleShot.getY()!=1 && lastShot.getY() < doubleShot.getY()){
                queue.push(new Cell(doubleShot.getX(),doubleShot.getY()-1));
            }
        }
            if (doubleShot.getY()==lastShot.getY()){
               if (doubleShot.getX()>lastShot.getX() && doubleShot.getX()!=20){
                   queue.push(new Cell(doubleShot.getX()+1,doubleShot.getY()));
               }else if (doubleShot.getX()<lastShot.getX() && doubleShot.getX()!=1){
                   queue.push(new Cell(doubleShot.getX()-1,doubleShot.getY()));
               }*/
/*
        if (!queue.isEmpty() && howMuchShot >= 1) {
            queue.peek().setShot(true);
            return queue.peek();
            if (arms.hit(queue.peek().getX(), queue.peek().getY()) && howMuchShot >= 2) {
                howMuchShot += 1;
                //if MINE OF SUBMARINE
                if (arms.)
            } else {
                howMuchShot += 1;
                anotherQueue(queue.peek());
            }
            queue.pop();
        } else {
            Cell cell = randomShot();
            if (arms.hit(cell.getX(), cell.getY())) {
                //check healthy ship, maybe he broke and that's all
                if (!arms.isMineOrSubmarine(cell.getX(), cell.getY())) {
                    howMuchShot += 1;
                    lastShot = cell;
                    doQueue(cell.getX(), cell.getY());
                    game_field.getGame_field()[cell.getX() - 1][cell.getY() - 1].setCell_color(colorShot);
                } else if (arms.isSubmarine(cell.getX(), cell.getY())) {


                }
            }
        }*/

