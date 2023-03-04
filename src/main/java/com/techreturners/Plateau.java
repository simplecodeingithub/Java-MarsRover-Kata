package com.techreturners;

public class Plateau {
    private int width;
    private int height;

    public Plateau(int width, int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Plateau dimensions must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public boolean isWithinBounds(int xCordinate, int yCordinate) {
        if (xCordinate < 0 || yCordinate < 0 || xCordinate >= width  || yCordinate >=height) {
            return false;
        }
        return true;

    }
}
