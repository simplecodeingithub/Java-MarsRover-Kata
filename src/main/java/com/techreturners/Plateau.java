package com.techreturners;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int width;
    private int height;
    private List<Rover> rovers;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
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
        rovers.add(rover);
    }
}
