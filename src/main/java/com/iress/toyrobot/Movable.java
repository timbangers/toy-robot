package com.iress.toyrobot;

/**
 * This interface contains methods that a class must implement
 */
public interface Movable {

    DIRECTION turnLeft();
    DIRECTION turnRight();
    Coordinates move(Coordinates coordinates);
}
