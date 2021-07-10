package com.iress.toyrobot;

public class RobotController {

    private Robot robot;

    public RobotController(Robot robot) {
        this.robot = robot;
    }

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

    public void move(){
        if (Utilities.isPlaced(robot)){
            robot.getDirection().move(robot.getCoordinates());
        }
    }

    public void location(){
        if (robot.getCoordinates() != null) {
            System.out.println(String.format("%d,%d %s", robot.getCoordinates().getxCoordinate(), robot.getCoordinates().getyCoordinate(), robot.getDirection()));
        } else {
            System.out.println("Invalid coordinates, pls try again");
        }
    }

    public void place(Coordinates coordinates, DIRECTION direction){
            robot.setCoordinates(coordinates);
            robot.setDirection(direction);
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

}
