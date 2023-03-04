package com.techreturners;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/rover-movement.csv", numLinesToSkip = 1)

    public void testMoveRover(int width,int height,int startX,int startY,String startDirection,String instructions,boolean valid,int endX,int endY,String endDirection){
        Plateau plateau=new Plateau(width, height);
        MissionControl missionControl=new MissionControl(plateau);
        Rover rover=new Rover(startX,startY,Direction.valueOf(startDirection));

        if (!plateau.isWithinBounds(rover.getxCordinate(), rover.getyCordinate())) {
            assertThrows(IllegalArgumentException.class, () -> missionControl.addRover(rover));
            return;
        }

        if (valid) {
            missionControl.addRover(rover);
            try{
            boolean moveSuccessful = missionControl.moveRover(rover, instructions);
            assertTrue(moveSuccessful);
            assertEquals(endX, rover.getxCordinate());
            assertEquals(endY, rover.getyCordinate());
            assertEquals(Direction.valueOf(endDirection), rover.getDirection());
        }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
                missionControl.addRover(rover);
                try{
                missionControl.moveRover(rover,instructions);
                }catch (IllegalArgumentException e){
                assertEquals("Rover is out of bounds!",e.getMessage());
            }
        }
    }

}

