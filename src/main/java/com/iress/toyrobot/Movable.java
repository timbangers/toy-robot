package com.iress.toyrobot;

public interface Movable {

    DIRECTION turnLeft();
    DIRECTION turnRight();
    Coordinates move(Coordinates coordinates);
}
