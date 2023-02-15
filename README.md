# Java-MarsRover-Kata

This is a program to move rovers around the surface of Mars, represented by a plateau.
The surface of Mars is represented by a Plateau, which is a square/rectangular grid. Rovers navigate the Plateau so they can collect samples and send them back to Planet Earth.

How the Mars Rover Works:

The plateau is divided into a grid, and a rover's position is represented by x and y co-ordinates and the letters N, S, W, E to represent North, South, West, East (the four cardinal compass points) respectively.

To move a rover around the plateau, a string of letters is sent to a rover. Here are the letters and their resultant action:

  L: Spins the rover 90 degrees left without moving from the current coordinate point.

  R: Spins the rover 90 degrees right without moving from the current coordinate point.

  M: Moves the rover one grid point in the direction it is facing.

Input Format:

The first line of input represents the top-right coordinates of the Plateau, which are separated by a space.
Each rover has two lines of input. 
   The first line gives the rover's initial position and heading, and the second line is a series of instructions telling the rover how to explore the Plateau.

The input format for the rover's initial position and heading is:

    The first two integers represent the rover's x and y coordinates.
  
    The third character represents the direction the rover is facing. It can be 'N', 'S', 'E', or 'W' for North, South, East, or West, respectively.
  
    The input format for the instructions is a string of characters containing only 'L', 'R', and 'M'. 'L' and 'R' turn the rover left or right, respectively, without moving from the current position. 'M' moves the rover one grid point in the current direction.

Output Format:

 The output for each rover consists of the rover's final coordinates and heading.

 The output format for the final position and heading is:

    The first two integers represent the rover's x and y coordinates.
    The third character represents the direction the rover is facing. It can be 'N', 'S', 'E', or 'W' for North, South, East, or West, respectively.
  
 Create a program that implements the rules for the Mars Rover. Apply Test-Driven Development (TDD) to test-drive your solution as you build it.
 
 Example Testcases:
 
 Input:
 
5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM


Output:

1 3 N

5 1 E




