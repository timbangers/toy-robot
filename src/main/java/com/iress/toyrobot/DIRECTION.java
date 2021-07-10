package com.iress.toyrobot;

public enum DIRECTION implements Movable {
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
