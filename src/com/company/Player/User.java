package com.company.Player;

import com.company.Arms.Arms;
import com.company.Arms.Ship;
import com.company.Field.Cell;
import com.company.Field.Game_field;
import javafx.scene.paint.Color;

import java.util.Scanner;

public class User implements Player {
    private Arms arms;
    private Game_field game_field;
    private Scanner scanner = new Scanner(System.in);

    public User() {
    }

    @Override
    public boolean hit(Cell cell) {
        return arms.hit(cell.getX(), cell.getY());
    }

    public void colorShotShip(Cell cell) {
        game_field.getGame_field()[cell.getX()][cell.getY()].setCell_color(Color.RED);
    }
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
            if (ship.isVertically()) {
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
                    game_field.getGame_field()[x - 1][y - 2].setShot(true);
                    outlineX(x, y);
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
            game_field.getGame_field()[x - 2][y - 1].setShot(true);
        }
        if (x != 10) {
            game_field.getGame_field()[x][y - 1].setShot(true);
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
        }
    }
    @Override
    public Cell whereShot(boolean lastShot) {
        System.out.println("where");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Cell(x, y);
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
    public Cell giveMineCell() {
        return arms.getMine().getMine();
    }

    @Override
    public void addMineCell(Cell cell) {
        game_field.getGame_field()[cell.getX() - 1][cell.getY() - 1].setCell_color(Color.RED);
    }

    @Override
    public boolean isMine(Cell cell) {
        return arms.isMine(cell.getX(), cell.getY());
    }

    @Override
    public boolean allShipIsDead() {
        return arms.deadAllShip();
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
    public void addCellShip(Cell cell) {
        game_field.getGame_field()[cell.getX() - 1][cell.getY() - 1].setCell_color(Color.BLUE);
    }

    @Override
    public Cell randomPointShip() {
        return arms.randomPoint();
    }

    public Arms getArms() {
        return arms;
    }

    public void setArms(Arms arms) {
        this.arms = arms;
    }

    public Game_field getGame_field() {
        return game_field;
    }

    public void setGame_field(Game_field game_field) {
        this.game_field = game_field;
    }
}
