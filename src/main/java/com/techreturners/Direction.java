package com.techreturners;

public enum Direction {
    N,
    E,
    S,
    W;

    public Direction turnLeft(){
        int index=(this.ordinal()+3) %4;
        return Direction.values()[index];
    }

    public Direction turnRight(){
        int index=(this.ordinal()+1) %4;
        return Direction.values()[index];
    }
}