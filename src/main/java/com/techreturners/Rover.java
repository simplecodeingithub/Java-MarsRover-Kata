package com.techreturners;

public class Rover {
    private int xCordinate;
    private int yCordinate;
    private char direction;

    public Rover(int xCordinate, int yCordinate, char direction) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.direction = direction;
    }

    public int getxCordinate() {
        return xCordinate;
    }

    public void setxCordinate(int xCordinate) {
        this.xCordinate = xCordinate;
    }

    public int getyCordinate() {
        return yCordinate;
    }

    public void setyCordinate(int yCordinate) {
        this.yCordinate = yCordinate;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void move(String commands) {
        for (char command : commands.toCharArray())
            switch (command) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    moveForward();
                    break;
                    default:
                    throw new IllegalArgumentException("Invalid command:" + command);
            }
    }

    private void turnLeft(){
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
     private void turnRight(){
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
      private void moveForward(){
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
      }


      // Getter method to retrieve the current position and direction of the rover
    public String getPosition(){
        return String.format("%d %d %c",xCordinate,yCordinate,direction);
    }
}




