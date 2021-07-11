package com.iress.toyrobot;

public class Utilities {

    public static boolean isOnTable(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= Constants.TABLE_WIDTH_START && yCoordinate >= Constants.TABLE_HEIGHT_START
                && xCoordinate <= Constants.TABLE_WIDTH_END && yCoordinate <= Constants.TABLE_HEIGHT_END) ? true : false;
    }

    public static boolean isOnTable(Coordinates coordinates) {
        return isOnTable(coordinates.getxCoordinate(), coordinates.getyCoordinate());
    }

    public static boolean isPlaced(Robot robot){
        return robot.getCoordinates() != null && isOnTable(robot.getCoordinates()) ? true : false;
    }

    public static Coordinates getCoordinateFromInput(String line){
        return new Coordinates(Integer.parseInt(getLocationFromInput(line)[0]), Integer.parseInt(getLocationFromInput(line)[1]));
    }

    public static DIRECTION getDirectionFromInput(String line){
        return DIRECTION.valueOf(getLocationFromInput(line)[2]);

    }

    public static String[] getLocationFromInput(String line){
        String[] lineArray = line.split("[ ]+");
        return lineArray[1].split(",");
    }

}
