# Toy Robot program

### Requirement:
The application is a simulation of a toy robot moving on a square table top, of dimensions 5 unit x 5 units. 
There are no obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented from falling to destruction.
Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.

Create a console application that can read in commands of the following form - 
    `PLACE X,Y,F`
    `MOVE`
    `LEFT`
    `RIGHT`
    `REPORT`
    
`PLACE` will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.
It is required that the first command to the robot is a PLACE command, after that, any sequence of commands may be issues, in any order, including another PLACE command.
The application should discard all commands in the sequence until a valid PLACE command has been executed.
`MOVE` will move the toy robot one unit forward in the direction it is currently facing.
`LEFT` and `RIGHT` will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
`REPORT` will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.
A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands.
   
The toy robot must not fall off the table during movement. This also includes the initial placement of the toy robot. Any move that would cause hte robot to fall must be ignored.   

### How to run the program:
To compile, run below command at the project root directory:

    `javac src/main/java/Robot.java src/main/java/Table.java src/main/java/Main.java`
    
To execute, run below command at the project root directory:

    `java -cp src/main/java Main`
    
Example of inputs:

Example 1:

    `PLACE 0,0,NORTH`

    `MOVE`

    `RIGHT`

    `MOVE`

    `REPORT`

    `Output: 1,1,EAST`

Example 2:

    `PLACE 2,2,EAST`

    `LEFT`

    `MOVE`

    `RIGHT`

    `MOVE`

    `REPORT`

    `Output: 3,3,EAST`

Example of ignored inputs:

Example 1:

    `MOVE`

    `REPORT`

Example 2:

    `PLACE 5,4,EAST`

    `REPORT`