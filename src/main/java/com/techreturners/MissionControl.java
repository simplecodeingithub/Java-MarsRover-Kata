package com.techreturners;

import java.util.ArrayList;

public class MissionControl {
    private Plateau plateau;
    private ArrayList<Rover> rovers;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
        rovers = new ArrayList<>();
    }

    public void addRover(Rover rover) {
        // Check if the rover is within the bounds of the plateau
        if (!plateau.isWithinBounds(rover.getxCordinate(), rover.getyCordinate())){
           throw new IllegalArgumentException("Rover is out of bounds!");
        }
        // Check if the rover conflicts with any of the other rovers on the plateau
        for (Rover r : rovers) {
                if (r.getxCordinate() == rover.getxCordinate() &&
                        r.getyCordinate() == rover.getyCordinate()) {
                    throw new IllegalArgumentException("Another rover already occupies this space!");
                }
            }
            rovers.add(rover);
        }

        public boolean moveRover(Rover rover ,String instructions) {
            //rover = rovers.get(rovers.size() - 1);
            int originalX = rover.getxCordinate();
            int originalY = rover.getyCordinate();
            Direction originalDirection = rover.getDirection();
            for (char instruction : instructions.toCharArray()) {
                switch (instruction) {
                    case 'L':
                        rover.turnLeft();
                        break;
                    case 'R':
                        rover.turnRight();
                        break;
                    case 'M':
                        rover.move();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid instruction: " + instruction);
                }
            }
            int nextX = rover.getxCordinate();
            int nextY = rover.getyCordinate();
            if (!plateau.isWithinBounds(rover.getxCordinate() - 1, rover.getyCordinate() - 1)) {
                throw new IllegalArgumentException("Rover is out of bounds!");
            }

            for (Rover r : rovers) {
                if (r != rover && r.getxCordinate() == nextX && r.getyCordinate() == nextY) {
                    // return false;
                    rover.setCoordinates(originalX, originalY);
                    rover.setDirection(originalDirection);
                    throw new IllegalArgumentException("Rover cannot move to a space occupied by another rover!");
                }
            }
            return true;

        }}
