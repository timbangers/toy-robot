package com.iress.toyrobot.test;

import com.iress.toyrobot.Coordinates;
import com.iress.toyrobot.DIRECTION;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class DirectionTest {
    @Test
    public void testTurnLeft(){
        Arrays.stream(DIRECTION.values()).forEach(direction -> {
            switch (direction){
                case EAST:
                    assertEquals(DIRECTION.NORTH, direction.turnLeft());
                    break;
                case WEST:
                    assertEquals(DIRECTION.SOUTH, direction.turnLeft());
                    break;
                case NORTH:
                    assertEquals(DIRECTION.WEST, direction.turnLeft());
                    break;
                case SOUTH:
                    assertEquals(DIRECTION.EAST, direction.turnLeft());
                    break;
                default:
                    break;
            }
        });
    }

    @Test
    public void testTurnRight(){
        Arrays.stream(DIRECTION.values()).forEach(direction -> {
            switch (direction){
                case EAST:
                    assertEquals(DIRECTION.SOUTH, direction.turnRight());
                    break;
                case WEST:
                    assertEquals(DIRECTION.NORTH, direction.turnRight());
                    break;
                case NORTH:
                    assertEquals(DIRECTION.EAST, direction.turnRight());
                    break;
                case SOUTH:
                    assertEquals(DIRECTION.WEST, direction.turnRight());
                    break;
                default:
                    break;
            }
        });
    }

    @Test
    public void testMove(){
        Arrays.stream(DIRECTION.values()).forEach(direction -> {
                Coordinates c = new Coordinates(3,3);
                switch (direction){
                    case EAST:
                        assertEquals(new Coordinates(4,3).getxCoordinate(), direction.move(c).getxCoordinate());
                        break;
                    case WEST:
                        assertEquals(new Coordinates(2,3).getxCoordinate(), direction.move(c).getxCoordinate());
                        break;
                    case NORTH:
                        assertEquals(new Coordinates(3,4).getyCoordinate(), direction.move(c).getyCoordinate());
                        break;
                    case SOUTH:
                        assertEquals(new Coordinates(3,2).getyCoordinate(), direction.move(c).getyCoordinate());
                        break;
                    default:
                        break;
                }

        });
    }
}
