package com.iress.toyrobot;

/**
 * This RobotController class gives commands to a Robot
 */
public class ToyRobotController {

    private ToyRobot robot;

    public ToyRobotController(ToyRobot robot) {
        this.robot = robot;
    }

    /**
     * Turns a robot to a given direction
     * @param turnDirection
     */
    public void turn(String turnDirection){
        if (Utilities.isPlaced(this.robot)) {
            switch (turnDirection) {
                case Constants.COMMAND_TURN_LEFT:
                    this.robot.setDirection(this.robot.getDirection().turnLeft());
                    break;
                case Constants.COMMAND_TURN_RIGHT:
                    this.robot.setDirection(this.robot.getDirection().turnRight());
                    break;
                default :
                    break;
            }
        }
    }

    /**
     * Moves the robot. An unplaced robot will be ignored
     */
    public void move(){
        if (Utilities.isPlaced(robot)){
            robot.getDirection().move(robot.getCoordinates());
        }
    }

    /**
     * Gives the location of a robot. An unplaced robot will not have coordinates
     */
    public void location(){
        if (robot.getCoordinates() != null) {
            System.out.println(String.format("%d,%d %s", robot.getCoordinates().getxCoordinate(), robot.getCoordinates().getyCoordinate(), robot.getDirection()));
        } else {
            System.out.println("Invalid coordinates, pls try again");
        }
    }

    /**
     * This method palces or gives a robot valid coordinates within the limits of the table
     * @param coordinates
     * @param direction
     */
    public void place(Coordinates coordinates, DIRECTION direction){
            robot.setCoordinates(coordinates);
            robot.setDirection(direction);
    }

    public ToyRobot getRobot() {
        return robot;
    }
}
