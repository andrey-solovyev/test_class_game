package com.company.Player;

import com.company.Arms.Arms;
import com.company.Arms.Mine;
import com.company.Arms.Minesweeper;
import com.company.Arms.Ship;
import com.company.Arms.Submarine;
import com.company.Field.Cell;
import com.company.Field.Game_field;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Robot implements Player {
    private Stack<Cell> queue = new Stack<>();
    private Arms arms;
    private Game_field game_field = new Game_field();
    private Color colorShot = Color.RED;
    private int howMuchShot = 0;//it is for the second shot and other
    private Cell lastShot;
    private ArrayList<Cell> cellShot = new ArrayList<>();
    private int draw = 0;

    private void draw() {
        for (int i = 0; i < game_field.getGame_field().length; i++) {
            for (int k = 0; k < game_field.getGame_field().length; k++) {
                if (game_field.getGame_field()[i][k].isShot()) {
                    System.out.print("#");
                } else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }

    public Cell whereShot(boolean islastShot) {
        hey();
        draw();
        if (islastShot) {
            howMuchShot = +1;
            if (howMuchShot == 2) {
                anotherQueue(cellShot.get(cellShot.size() - 2));
                if (game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].isShot()) {
                    queue.pop();
                }
                cellShot.add(queue.peek());
                game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].setShot(true);
                return lastShot = queue.pop();
            }
            if (queue.isEmpty()) {
                 doQueue(lastShot.getX(), lastShot.getY());
                if (queue.isEmpty()) {
                    return randomShot();
                }
                game_field.getGame_field()[lastShot.getX() - 1][lastShot.getY() - 1].setShot(true);
                if (game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].isShot()) {
                    queue.pop();
                }
                cellShot.add(queue.peek());
                game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].setShot(true);
                return lastShot = queue.pop();

            }
        }
        if (!queue.isEmpty()) {
            if (queue.peek().getX() == 11 || queue.peek().getY() == 11) {
                queue.pop();
                whereShot(false);
            }

            cellShot.add(queue.peek());
            game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].setShot(true);
            return lastShot = queue.pop();
        }
        howMuchShot = 0;
        return randomShot();
    }


    private void hey() {
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i).getX() + "  " + queue.get(i).getY() + " ");
        }
    }

    private Cell randomShot() {
        howMuchShot = 0;
        queue.clear();
        Random random = new Random();
        int i = random.nextInt(10);
        int k = random.nextInt(10);
        lastShot = new Cell(i, k);
        if (lastShot.isShot()) {
            return randomShot();
        }
        //  System.out.println(i+" "+k);

        cellShot.add(lastShot);
        game_field.getGame_field()[i][k].setShot(true);
        return lastShot;
    }
/*
    private void outline(Ship ship) {

        for (int i = 0; i < ship.getShips_cells().length; i++) {
            int x = ship.getCell(i).getX();
            int y = ship.getCell(i).getY();
            if (ship.getSize() == 1) {
                outlineY(ship.getShips_cells()[0].getX(), ship.getCell(0).getY());
                if (x != 1) {
                    game_field.getGame_field()[x - 2][y - 1].setShot(true);
                    outlineY(x - 1, y);
                }
                if (x != 10) {
                    game_field.getGame_field()[x][y - 1].setShot(true);
                    outlineY(x + 1, y);
                }
                break;
            }
            if (!ship.isVertically()) {
                if (x != 1 && i == 0) {
                    game_field.getGame_field()[x - 2][y - 1].setShot(true);
                    outlineY(x - 1, y);
                }
                if (i != ship.getShips_cells().length - 1) {
                    outlineY(x, y);
                } else {
                    if (x != 10) {
                        game_field.getGame_field()[x][y - 1].setShot(true);
                        outlineY(x + 1, y);
                    }
                }
            } else {
                if (y != 1 && i == 0) {
                    if (y-1==ship.getCell(i+1).getY()){
                        game_field.getGame_field()[x - 1][y - 2].setShot(true);
                    } else {
                        game_field.getGame_field()[x - 1][y - 2].setShot(true);
                        outlineX(x, y - 1);
                    }
                } else if (i != ship.getShips_cells().length - 1) {
                    outlineX(x, y);
                } else {
                    if (y != 10) {
                        game_field.getGame_field()[x - 1][y].setShot(true);
                        outlineX(x, y + 1);
                    }
                }

            }

        }
       // System.out.println(ship.getSize()+" size "+ship.getCell(0).getX()+" "+ship.getCell(0).getY()+" first "+ship.getCell(ship.getSize()-1).getX()+" "+ship.getCell(0).getY()+ship.getCell(ship.getSize()-1).getY());
     //   draw();
    }

    private void outlineY(int x, int y) {
        if (y != 1) {
            game_field.getGame_field()[x][y - 2].setShot(true);
        }
        if (y != 10) {
            game_field.getGame_field()[x][y].setShot(true);
        }
    }

    private void outlineX(int x, int y) {
        if (x != 1) {
            game_field.getGame_field()[x - 2][y ].setShot(true);
        }
        if (x != 10) {
            game_field.getGame_field()[x][y].setShot(true);
        }
    }*/
private static void outline(Ship ship) {

    for (int i = 0; i < ship.getShips_cells().length; i++) {
        int x = ship.getCell(i).getX();
        int y = ship.getCell(i).getY();

        if (ship.isVertically()) {//test OK
            if (x != 1 && i == 0) {
                game_field.getGame_field()[x - 1][y].setShot(true);
                game_field.getGame_field()[x - 1][y+1].setShot(true);
                outlineX(x + 1, y);//test OK
                outlineX(x, y);

            }
            if (i != ship.getShips_cells().length - 1) {
                outlineX(x + 1, y);

            } else {
                game_field.getGame_field()[x+1][y].setShot(true);
                game_field.getGame_field()[x+1][y+1].setShot(true);
                outlineX(x+1, y );
                outlineX(x+2,y);
            }
        } else {
            if (y != 1 && i == 0) {
                game_field.getGame_field()[x ][y-1].setShot(true);
                // game_field.getGame_field()[x][y-1].setShot(true);
                outlineY(x , y+1);//test OK
                outlineY(x, y);
            } else if (i != ship.getShips_cells().length - 1) {
                outlineY(x, y+1);
            } else {
                game_field.getGame_field()[x+1][y+1].setShot(true);
                game_field.getGame_field()[x][y+1].setShot(true);
                outlineY(x, y + 1);
                outlineY(x, y + 2);

            }

        }

    }
    System.out.println(ship.getSize() + " size " + ship.getCell(0).getX() + " " + ship.getCell(0).getY() + " first " + ship.getCell(ship.getSize() - 1).getX() + " " + ship.getCell(0).getY() + ship.getCell(ship.getSize() - 1).getY());

}

    private static void outlineY(int x, int y) {
        if (x != 1) {
            game_field.getGame_field()[x - 1][y-1].setShot(true);
        }
        if (x != 10) {
            game_field.getGame_field()[x][y-1].setShot(true);
        }
    }

    private static void outlineX(int x, int y) {
        if (y != 0) {
            game_field.getGame_field()[x - 1][y - 1].setShot(true);
        }
        if (y != 10) {
            game_field.getGame_field()[x - 1][y].setShot(true);
        }
    }

    @Override
    public Ship isDeadShip(Cell cell) {
        return arms.isDeadShip(cell);
    }

    @Override
    public void giveDeadShip(Ship ship) {
        if (ship != null) {
            outline(ship);
            System.out.println("Enter");
        }
    }

    @Override
    public boolean allShipIsDead() {
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
        queue.clear();
        System.out.println(cell.getX() + " " + cell.getY());
        doQueue(cell.getX(), cell.getY());
    }

    @Override
    public Cell randomPointShip() {
        return arms.randomPoint();
    }

    public void fieldShip() {
        Arms arms1 =
                new Arms(new Ship(4, 2, 1, 6, 1, false), (new Ship(3, 2, 3, 4, 3, false)), new Ship(3, 1, 5, 1, 7, true), new Ship(2, 19, 1, 10, 1, true), new Ship(2, 18, 3, 18, 4, false), new Ship(2, 5, 5, 5, 6, false), new Ship(1, 3, 20, 3, 20, false), new Ship(1, 18, 20, 18, 20, false), new Ship(1, 4, 18, 4, 18, false), new Ship(1, 19, 17, 19, 17, false), new Mine(1, 1), new Submarine(1, 8), new Minesweeper(20, 20));
        arms = arms1;
    }

    private void doQueue(int x, int y) {
        if (x + 1 <= 10 && x - 1 >= 1 && y + 1 <= 10 && y - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (x + 1 <= 10 && x - 1 >= 1 && y == 1) {
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (x == 10 && y + 1 <= 10 && y - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (y == 10 && x + 1 <= 10 && x - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x - 1, y));
        } else if (x == 1 && y + 1 <= 10 && y - 1 >= 1) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
            //we must check cell(20,1),(20,20),(1,20)(1,1)
        } else if (x == 10 && y == 1) {
            queue.push(new Cell(x, y + 1));
            queue.push(new Cell(x - 1, y));
        } else if (x == 10 && y == 10) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x - 1, y));
        } else if (x == 1 && y == 10) {
            queue.push(new Cell(x, y - 1));
            queue.push(new Cell(x + 1, y));
        } else if (x == 1 && y == 1) {
            queue.push(new Cell(x + 1, y));
            queue.push(new Cell(x, y + 1));
        }//i do not know! TEST this queue DO NOT REMEMBER

    }

    private void anotherQueue(Cell lastShot) {
        queue.clear();
        if (lastShot.getX() == this.lastShot.getX()) {
            if (this.lastShot.getY() + 1 != lastShot.getY() && this.lastShot.getY() != 10) {
                queue.push(new Cell(lastShot.getX(), this.lastShot.getY() + 1));
                if (lastShot.getY() != 1) {
                    queue.push(new Cell(lastShot.getX(), lastShot.getY() - 1));
                }
            } else if (this.lastShot.getY() != 1) {
                queue.push(new Cell(lastShot.getX(), this.lastShot.getY() - 1));
                if (lastShot.getY() != 10) {
                    queue.push(new Cell(lastShot.getX(), lastShot.getY() + 1));
                }
            }
        } else if (lastShot.getY() == this.lastShot.getY()) {
            if (this.lastShot.getX() - 1 != lastShot.getX() && this.lastShot.getX() != 1) {
                queue.push(new Cell(this.lastShot.getX() - 1, this.lastShot.getY()));
                if (lastShot.getX() != 10) {
                    queue.push(new Cell(lastShot.getX() + 1, lastShot.getY()));
                }
            } else if (this.lastShot.getX() + 1 != lastShot.getX() && this.lastShot.getX() != 10) {
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
 /*   if (ifHit){
            howMuchShot++;
            if (howMuchShot>=2){
                anotherQueue();
            }
        }
     Cell[] o=new Cell[queue.size()];
     queue.toArray(o);
     for(Cell cell:o){
         System.out.println(cell.getX()+" "+cell.getY()+" queue" );
     }
        if (!queue.isEmpty()) {
            while (game_field.getGame_field()[queue.peek().getX() - 1][queue.peek().getY() - 1].isShot()) {
               lastShot= queue.pop();
            }
            lastShot=queue.peek();
            game_field.getGame_field()[queue.peek().getX()-1][queue.peek().getY()-1].setShot(true);
            return queue.peek();
        } else {
            return lastShot=randomShot();
        }*/
