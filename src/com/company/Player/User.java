package com.company.Player;

import com.company.AllLogic.Game;
import com.company.Arms.Arms;
import com.company.Field.Cell;
import com.company.Field.Game_field;
import javafx.scene.paint.Color;
import sun.misc.CEFormatException;

import java.util.Scanner;

public class User implements Player {
    private Arms arms;
    private Game_field game_field;
    private Scanner scanner=new Scanner(System.in);

    public User() {
    }

    @Override
    public boolean hit(Cell cell) {
        return arms.hit(cell.getX(), cell.getY());
    }

    public void colorShotShip(Cell cell) {
        game_field.getGame_field()[cell.getX()][cell.getY()].setCell_color(Color.RED);
    }
    public Cell whereShot(){
        System.out.println("where");
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        return new Cell(x,y);
    }

    public boolean isMine(Cell cell){
        return arms.isMine(cell.getX(),cell.getY());
    }
    public boolean isSubmarine(Cell cell){
        return arms.isSubmarine(cell.getX(),cell.getY());
    }
    public boolean isMineswepeer(Cell cell){
        return arms.isMineswepeer(cell.getX(),cell.getY());
    }
    @Override
    public void addCellShip(Cell cell){
        game_field.getGame_field()[cell.getX()-1][cell.getY()-1].setCell_color(Color.BLUE);
    }
    @Override
    public Cell randomPointShip(){
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
