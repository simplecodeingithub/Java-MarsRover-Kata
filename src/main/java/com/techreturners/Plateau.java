package com.techreturners;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int width;
    private int height;
    private List<Rover> rovers;

    public Plateau(int width, int height) {
        if(width < 1 || height < 1 ){
            throw new IllegalArgumentException("Plateau dimensions must be positive");
        }
        this.width = width-1;
        this.height = height-1;
        rovers=new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }
    public void addRover(Rover rover){
        rovers.add(rover);
    }
    public void removeRover(Rover rover){
        rovers.remove(rover);
    }

    public boolean withinBounds(int xCordinate, int yCordinate) {
        if(xCordinate < 0 || yCordinate <0 || xCordinate > width || yCordinate > height){
            return false;
        }
        return true;
    }

    public boolean overlaps(Plateau otherOne){
        if(otherOne==null){
            throw new IllegalArgumentException("cannot check for overlap with null plateau");
        }
        int otherXmax=otherOne.getWidth();
        int otherYmax=otherOne.getHeight();
        if(this.width<otherXmax || this.height<otherYmax || otherOne.getWidth()<0 || otherOne.getHeight()<0){
            return false;
        }
        return true;
    }
}
