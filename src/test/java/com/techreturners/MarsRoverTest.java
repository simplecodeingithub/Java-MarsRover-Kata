package com.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {
  @Test
    public void testMoveForward(){
      Plateau plateau=new Plateau(5,5);
      Rover rover1=new Rover(1,2,'N');
      plateau.addRover(rover1);
      //rover1.move("M");
      rover1.move("LMLMLMLMM");
      assertEquals("1 3 N",rover1.getPosition());
      System.out.println("The final position is :" + rover1.getPosition());

      Rover rover2=new Rover(3,3,'E');
      plateau.addRover(rover2);
      rover2.move("MMRMMRMRRM");
      assertEquals("5 1 E",rover2.getPosition());
      System.out.println("The final position is :" + rover2.getPosition());
  }
  @Test
  public void testMoveOutOfPlateau(){
    Plateau plateau=new Plateau(5,5);
    Rover rover1=new Rover(0,0,'N');
    plateau.addRover(rover1);
    rover1.move("MMMMM");
    assertEquals("0 5 N",rover1.getPosition());

    Rover rover2=new Rover(5,5,'S');
    plateau.addRover(rover2);
    rover2.move("MMMMM");
    assertEquals("5 0 S",rover2.getPosition());
  }

}
