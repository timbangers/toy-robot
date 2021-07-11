package com.iress.toyrobot;

/**
 * This ToyRobot class contains a location in the form of coordinates and a direction (North, South, East, West)
 */
public class ToyRobot {

    Coordinates coordinates;
    DIRECTION direction;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }
}
