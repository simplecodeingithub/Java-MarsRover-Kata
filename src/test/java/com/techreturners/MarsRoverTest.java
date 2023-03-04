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

        if (valid) {
            missionControl.addRover(rover);
            boolean moveSuccessful = missionControl.moveRover(rover, instructions);
            assertTrue(moveSuccessful);
            assertEquals(endX, rover.getxCordinate());
            assertEquals(endY, rover.getyCordinate());
            assertEquals(Direction.valueOf(endDirection), rover.getDirection());
        } else {
           IllegalArgumentException exception= assertThrows(IllegalArgumentException.class, () ->{
                missionControl.addRover(rover);
                missionControl.moveRover(rover,instructions);
                //assertEquals(expectedExceptionMessgae,exception.getMessage());
            },"Rover cannot move outside Plateau boundaries");

        }
    }

}

  /*@Test
  public void testMoveForward_with_Single_Command() {
      Plateau plateau = new Plateau(5, 5);
      //adding rover1 to plateau to check movements with single command
      Rover rover1 = new Rover(3, 3, 'N');
      plateau.addRover(rover1);
      rover1.move("M");
      assertEquals("3 4 N", rover1.getPosition());
      System.out.println("The final position is :" + rover1.getPosition());
  }

   @Test
   public void testMoveForward_with_MultipleCommands() {
       Plateau plateau = new Plateau(5, 5);
       Rover rover2 = new Rover(1, 2, 'N');
       plateau.addRover(rover2);
       rover2.move("LMLMLMLMM");
       assertEquals("1 3 N", rover2.getPosition());
       System.out.println("The final position is :" + rover2.getPosition());
   }
    @Test
    public void testMoveForward_oneRoverWithDiffInput() {
      Plateau plateau = new Plateau(5, 5);
      Rover rover3 = new Rover(3, 3, 'E');
      plateau.addRover(rover3);
      rover3.move("MMRMMRMRRM");
      assertEquals("5 1 E", rover3.getPosition());
      System.out.println("The final position is :" + rover3.getPosition());
  }

  @Test
  public void testMoveOutOfPlateau() {
    Plateau plateau = new Plateau(5, 5);
    //we move rover1 forward 5 units to the top of plateau,valid move
    Rover rover1 = new Rover(0, 0, 'N');
    plateau.addRover(rover1);
    rover1.move("MMMMM");
    assertEquals("0 5 N", rover1.getPosition());
    System.out.println("The final position is :" + rover1.getPosition());

    //we attempt to move rover2 forward 5 units towards bottom of the plateau
    Rover rover2 = new Rover(5, 5, 'S');
    plateau.addRover(rover2);
    //try to move the rover out of the plateau
    try {
      rover2.move("MMMMM");
    } catch (IllegalArgumentException e) {
      assertEquals("Rover is out of bounds of the plateau", e.getMessage());

    }
  }
  @Test
  public void testAddMultipleRovers(){
    Plateau plateau=new Plateau(5,5);
    //add two rovers to the plateau
    Rover rover1=new Rover(1,2,'N');
    Rover rover2=new Rover(3,3,'N');
    plateau.addRover(rover1);
    plateau.addRover(rover2);
    //make sure the rovers were added successfully
    assertEquals(2,plateau.getRovers().size());
    //move the rovers to ensure they don't collide with each
    rover1.move("LMLMLMLMM");
    rover2.move("MMRMMRMRRM");
    //check for final positions of the rovers
    assertEquals("1 3 N",rover1.getPosition());
    assertEquals("5 5 N",rover2.getPosition());
  }
  @Test
  public void testRemoveRover(){
    Plateau plateau=new Plateau(5,5);
    Rover rover1=new Rover(1,2,'N');
    Rover rover2=new Rover(3,3,'N');
    plateau.addRover(rover1);
    plateau.addRover(rover2);
    assertEquals(2,plateau.getRovers().size());
    //remove rover from plateau
    plateau.removeRover(rover1);
    assertEquals(1,plateau.getRovers().size());
  }
 @Test
  public void testInvalidCommnad(){
   Plateau plateau=new Plateau(5,5);
   Rover rover1=new Rover(1,2,'N');
   plateau.addRover(rover1);
   try {
     rover1.move("QT");
   }catch (IllegalArgumentException e){
     assertEquals("Invalid command:Q",e.getMessage());
   }
 }
 @Test
    public void testOverlap(){
     Plateau plateau=new Plateau(5,5);
     Rover rover1=new Rover(1,1,'N');
     Rover rover2=new Rover(2,2,'N');
     plateau.addRover(rover1);
     plateau.addRover(rover2);
     boolean overlap1=plateau.roversOverlap(rover1,rover2);
     //assertEquals("true",overlap1);
     assertTrue(overlap1);
 }
 @Test
    public void testOverlap_with_samePosition(){
     Plateau plateau=new Plateau(5,5);
     Rover rover1=new Rover(1,2,'N');
     Rover rover2=new Rover(1,2,'E');
     plateau.addRover(rover1);
     plateau.addRover(rover2);
     //check for overlap
     boolean overlap1=plateau.roversOverlap(rover1,rover2);
     //assertEquals("true",overlap1);
     assertTrue(overlap1);
 }
}
*/