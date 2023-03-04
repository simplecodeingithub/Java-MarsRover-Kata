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
    /*void turnLeft(){
        switch (direction) {
            case 'N':
                direction='W';
                break;
            case 'E':
                direction='N';
                break;
            case 'S':
                direction='E';
                break;
            case 'W':
                direction='S';
                break;
            default:
                throw new IllegalArgumentException("Invalid command:" + direction);
        }
    }
     void turnRight(){
         switch (direction) {
             case 'N':
                 direction='E';
                 break;
             case 'E':
                 direction='S';
                 break;
             case 'S':
                 direction='W';
                 break;
             case 'W':
                 direction='N';
                 break;
             default:
                 throw new IllegalArgumentException("Invalid command:" + direction);
         }
     }

     private void moveForward() {
        switch (direction) {
              case 'N':
                  yCordinate++;
                  break;
              case 'E':
                  xCordinate++;
                  break;
              case 'S':
                  yCordinate--;
                  break;
              case 'W':
                  xCordinate--;
                  break;
              default:
                  throw new IllegalArgumentException("Invalid command:" + direction);
          }
    }*/

    // Getter method to retrieve the current position and direction of the rover
    public String getPosition(){
        return String.format("%d %d %c",xCordinate,yCordinate,direction);
    }

    public void setxCordinate(int xCordinate) {
        this.xCordinate = xCordinate;
    }

    public void setyCordinate(int yCordinate) {
        this.yCordinate = yCordinate;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}




