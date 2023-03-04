package com.techreturners;

import javax.swing.text.Position;

public class Rover implements LunarVehicle{
    private int xCordinate;
    private int yCordinate;
    private Direction direction;

    public Rover(int xCordinate, int yCordinate, Direction direction) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.direction = direction;
    }

    public int getxCordinate() {
        return xCordinate;
    }

    public int getyCordinate() {
        return yCordinate;
    }

    public Direction getDirection() {
        return direction;
    }
    public void turnLeft(){
        direction=direction.turnLeft();
    }
    public void turnRight(){
        direction=direction.turnRight();
    }

    public void move() {
        switch (direction) {
            case N:
                yCordinate++;
                break;
            case E:
                xCordinate++;
                break;
            case S:
                yCordinate--;
                break;
            case W:
                xCordinate--;
                break;
                    default:
                    throw new IllegalArgumentException("Invalid command:" + direction);
            }

    }
 public void setCoordinates(int x,int y){
        this.xCordinate=x+1;
        this.yCordinate=y+1;
 }
   public void setDirection(Direction direction) {
        this.direction = direction;
    }
}




