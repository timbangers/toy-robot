package com.iress.toyrobot.test;

import com.iress.toyrobot.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class RobotControllerTest {
    Robot robot;
    RobotController controller;

    @BeforeEach
    public void setup(){
        robot = new Robot();
        Coordinates coordinates = new Coordinates(0,0);
        robot.setCoordinates(coordinates);
        controller = new RobotController(robot);

    }

    @Test
    public void testTurn(){
        Arrays.stream(DIRECTION.values()).forEach(direction -> {
            robot.setDirection(direction);
            controller.turn(Constants.COMMAND_TURN_LEFT);
            switch (direction){
                case EAST:
                    assertEquals(DIRECTION.NORTH, robot.getDirection());
                    break;
                case WEST:
                    assertEquals(DIRECTION.SOUTH, robot.getDirection());
                    break;
                case NORTH:
                    assertEquals(DIRECTION.WEST, robot.getDirection());
                    break;
                case SOUTH:
                    assertEquals(DIRECTION.EAST, robot.getDirection());
                    break;
                default:
                    break;
            }
        });

        Arrays.stream(DIRECTION.values()).forEach(direction -> {
            robot.setDirection(direction);
            controller.turn(Constants.COMMAND_TURN_RIGHT);
            switch (direction){
                case EAST:
                    assertEquals(DIRECTION.SOUTH, robot.getDirection());
                    break;
                case WEST:
                    assertEquals(DIRECTION.NORTH, robot.getDirection());
                    break;
                case NORTH:
                    assertEquals(DIRECTION.EAST, robot.getDirection());
                    break;
                case SOUTH:
                    assertEquals(DIRECTION.WEST, robot.getDirection());
                    break;
                default:
                    break;
            }
        });
    }


}
