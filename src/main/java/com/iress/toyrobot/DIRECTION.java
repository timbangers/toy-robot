package com.iress.toyrobot;

/**
 * This DIRECTION enum contains methods that instruct a Robot object, depending on where the Robot is currently pointed.
 * It implements Movable interface so that any new DIRECTION has the same methods to implement
 */
public enum DIRECTION implements Movable {
    /**
     * DIRECTION NORTH
     * turnRight will point to EAST
     * turnLeft will point to WEST
     * move will increment the y coordinate
     */
    NORTH {
        public DIRECTION turnRight(){
            return DIRECTION.EAST;
        }
        public DIRECTION turnLeft(){
            return DIRECTION.WEST;
        }
        public Coordinates move(Coordinates coordinates){
            if (Utilities.isOnTable(coordinates.getxCoordinate(), coordinates.getyCoordinate() + 1)){
                coordinates.incrementY();
                return coordinates;
            }
            return null;
        }
    },
    /**
     * DIRECTION SOUTH
     * turnRight will point to WEST
     * turnLeft will point to EAST
     * move will decrement the y coordinate
     */
    SOUTH {
        public DIRECTION turnRight(){
            return DIRECTION.WEST;
        }
        public DIRECTION turnLeft(){
            return DIRECTION.EAST;
        }
        public Coordinates move(Coordinates coordinates){
            if (Utilities.isOnTable(coordinates.getxCoordinate(), coordinates.getyCoordinate() - 1)){
                coordinates.decrementY();
                return coordinates;
            }
            return null;
        }
    },
    /**
     * DIRECTION EAST
     * turnRight will point to SOUTH
     * turnLeft will point to NORTH
     * move will increment the x coordinate
     */
    EAST {
        public DIRECTION turnRight(){
            return DIRECTION.SOUTH;
        }
        public DIRECTION turnLeft(){
            return DIRECTION.NORTH;
        }
        public Coordinates move(Coordinates coordinates){
            if (Utilities.isOnTable(coordinates.getxCoordinate() + 1, coordinates.getyCoordinate())){
                coordinates.incrementX();
                return coordinates;
            }
            return null;
        }
    },
    /**
     * DIRECTION WEST
     * turnRight will point to NORTH
     * turnLeft will point to SOUTH
     * move will decrement the x coordinate
     */
    WEST {
        public DIRECTION turnRight(){
            return DIRECTION.NORTH;
        }
        public DIRECTION turnLeft(){
            return DIRECTION.SOUTH;
        }
        public Coordinates move(Coordinates coordinates){
            if (Utilities.isOnTable(coordinates.getxCoordinate() - 1, coordinates.getyCoordinate())){
                coordinates.decrementX();
                return coordinates;
            }
            return null;
        }
    }
}
