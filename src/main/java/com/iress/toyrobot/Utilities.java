package com.iress.toyrobot;

/**
 * This class is a utility class for validation.
 */
public class Utilities {

    /**
     * This method checks if the given individual coordinates is within the parameters of the table width and height
     * @param xCoordinate
     * @param yCoordinate
     * @return boolean
     */
    public static boolean isOnTable(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= Constants.TABLE_WIDTH_START && yCoordinate >= Constants.TABLE_HEIGHT_START
                && xCoordinate <= Constants.TABLE_WIDTH_END && yCoordinate <= Constants.TABLE_HEIGHT_END) ? true : false;
    }

    /**
     * This method checks if the given Coordinates object is within the parameters of the table width and height
     * @param coordinates
     * @return boolean
     */
    public static boolean isOnTable(Coordinates coordinates) {
        return isOnTable(coordinates.getxCoordinate(), coordinates.getyCoordinate());
    }

    /**
     * This method checks if the robot has been placed meaning it contains valid coordinates
     * @param robot
     * @return boolean
     */
    public static boolean isPlaced(ToyRobot robot){
        return robot.getCoordinates() != null && isOnTable(robot.getCoordinates()) ? true : false;
    }


    /**
     * This method gets a Coordinates object from the PLACE input
     * @param line
     * @return Coordinates
     */
    public static Coordinates getCoordinateFromInput(String line){
        return new Coordinates(Integer.parseInt(getLocationFromInput(line)[0]), Integer.parseInt(getLocationFromInput(line)[1]));
    }

    /**
     * This method gets a DIRECTION object from the PLACE input
     * @param line
     * @return DIRECTION
     */
    public static DIRECTION getDirectionFromInput(String line){
        return DIRECTION.valueOf(getLocationFromInput(line)[2]);

    }

    /**
     * This method helps parse the PLACE input to get the coordinates and direction
     * @param line
     * @return String[]
     */
    public static String[] getLocationFromInput(String line){
        String[] lineArray = line.split("[ ]+");
        return lineArray[1].split(",");
    }

}
