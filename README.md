## toy-robot project

The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

Create a console application that can read in commands of the following form -
* PLACE X,Y,F
* MOVE
* LEFT
* RIGHT
* REPORT

PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0)
can be considered to be the SOUTH WEST most corner. It is required that the first command to the robot is a PLACE
command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The
application should discard all commands in the sequence until a valid PLACE command has been executed.
MOVE will move the toy robot one unit forward in the direction it is currently facing.
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.
A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands.
Input can be from a file, or from standard input, as the developer chooses.
Provide test data to exercise the application.

It is not required to provide any graphical output showing the movement of the toy robot.
The application should handle error states appropriately and be robust to user input.

### Constraints:
The toy robot must not fall off the table during movement. This also includes the initial placement of the toy robot. Any
move that would cause the robot to fall must be ignored.

### Running the app:
The app is built using gradle. Inputs are in the form of text files located in /resources.
Build the app into a jar first using:

`gradle build`

To run use the command:

`java -jar toy-robot.jar <filename>`

where <filename> is a file in the resources folder.

The sample files included in the resources folder are:

* initialoutoftable.txt
* invalidcommands.txt
* invalidplace.txt
* orignalposition.txt
* placemultiple.txt
* fallofftableandback.txt
* robot.txt

### Testing the app:
Running unit tests is simple as executing the command

`gradle test`

Alternatively, once the project is cloned and loaded into an ide, the test classes can be run from the test folder.

