package com.company.Player;

import com.company.Arms.Arms;
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
        if (!queue.isEmpty()) {
            while (game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].isShot()) {
                queue.pop();
            }
            return queue.peek();
        } else {
            return randomShot();
        }
    }

    private Cell randomShot() {
        Random random = new Random();
        int i = random.nextInt(10);
        int k = random.nextInt(10);
        lastShot = new Cell(i, k);
        if (!lastShot.isShot()) {
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
        } else if (arms.isMineOrSubmarine(cell.getX(), cell.getY())) {
            return true;
        }
        return false;
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

    private void anotherQueue(Cell doubleShot) {
        queue.clear();
        if (doubleShot.getX() == lastShot.getX()) {
            if (lastShot.getY() + 1 != doubleShot.getY() && lastShot.getY() != 20) {
                queue.push(new Cell(doubleShot.getX(), lastShot.getY() + 1));
                if (doubleShot.getY() != 1) {
                    queue.push(new Cell(doubleShot.getX(), doubleShot.getY() - 1));
                }
            } else if (lastShot.getY() != 1) {
                queue.push(new Cell(doubleShot.getX(), lastShot.getY() - 1));
                if (doubleShot.getY() != 20) {
                    queue.push(new Cell(doubleShot.getX(), doubleShot.getY() + 1));
                }
            }
        } else if (doubleShot.getY() == lastShot.getY()) {
            if (lastShot.getX() - 1 != doubleShot.getX() && lastShot.getX() != 1) {
                queue.push(new Cell(lastShot.getX() - 1, lastShot.getY()));
                if (doubleShot.getX() != 20) {
                    queue.push(new Cell(doubleShot.getX() + 1, doubleShot.getY()));
                }
            } else if (lastShot.getX() + 1 != doubleShot.getX() && lastShot.getX() != 20) {
                queue.push(new Cell(lastShot.getX() + 1, lastShot.getY()));
                if (doubleShot.getX() != 1) {
                    queue.push(new Cell(doubleShot.getX() - 1, doubleShot.getY()));
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

