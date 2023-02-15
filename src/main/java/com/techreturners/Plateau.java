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

    public boolean roversOverlap(Rover rover1, Rover rover2) {
        if (rover1 == null || rover2 == null) {
            throw new IllegalArgumentException("Cannot check for overlap with a null Rover");
        }
        if (rover1.equals(rover2)) {
            // Rovers cannot overlap with themselves
            return false;
        }
        if (rover1.getxCordinate() > rover2.getxCordinate() + 1 || rover2.getxCordinate() > rover1.getxCordinate() + 1) {
            // Rovers are not horizontally aligned
            return false;
        }
        if (rover1.getyCordinate() > rover2.getyCordinate() + 1 || rover2.getyCordinate() > rover1.getyCordinate() + 1) {
            // Rovers are not vertically aligned
            return false;
        }
        // Rovers overlap
        return true;
    }
}
