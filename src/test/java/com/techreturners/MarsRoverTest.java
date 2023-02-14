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
      assertEquals("1 3 N",rover1.toString());
      System.out.println("The final position is :" + rover1.toString());

      Rover rover2=new Rover(3,3,'E');
      plateau.addRover(rover2);
      rover2.move("MMRMMRMRRM");
      assertEquals("5 1 E",rover2.toString());
      System.out.println("The final position is :" + rover2.toString());
  }
}
