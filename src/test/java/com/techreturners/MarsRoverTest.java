package com.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MarsRoverTest {
  @Test
  public void testMoveForward() {
    Plateau plateau = new Plateau(5, 5);
    Rover rover1 = new Rover(1, 2, 'N');
    plateau.addRover(rover1);
    rover1.move("LMLMLMLMM");
    assertEquals("1 3 N", rover1.getPosition());
    System.out.println("The final position is :" + rover1.getPosition());

    Rover rover2 = new Rover(3, 3, 'E');
    plateau.addRover(rover2);
    rover2.move("MMRMMRMRRM");
    assertEquals("5 1 E", rover2.getPosition());
    System.out.println("The final position is :" + rover2.getPosition());
  }

  @Test
  public void testMoveOutOfPlateau() {
    Plateau plateau = new Plateau(5, 5);
    //we move rover1 forward 5 units to the tope of plateau,valid move
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

}
