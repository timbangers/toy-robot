package com.iress.toyrobot;

/**
 * This class represents an x and y axis coordinate
 */
public class Coordinates {

    int xCoordinate;
    int yCoordinate;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void incrementX() { this.xCoordinate++; }

    public void incrementY(){
        this.yCoordinate++;
    }

    public void decrementX() { this.xCoordinate--; }

    public void decrementY() { this.yCoordinate--; }

}
