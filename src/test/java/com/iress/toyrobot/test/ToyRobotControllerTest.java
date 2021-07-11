package com.iress.toyrobot.test;

import com.iress.toyrobot.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ToyRobotController
 */
public class ToyRobotControllerTest {
    ToyRobot robot;
    ToyRobotController controller;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @BeforeEach
    public void setup(){
        robot = new ToyRobot();
        Coordinates coordinates = new Coordinates(2,2);
        robot.setCoordinates(coordinates);
        controller = new ToyRobotController(robot);
        System.setOut(new PrintStream(baos));
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

    @Test
    public void testMove(){
        Arrays.stream(DIRECTION.values()).forEach(direction -> {
            robot.setDirection(direction);
            controller.move();
            switch (direction){
                case EAST:
                    assertEquals(new Coordinates(3,2).getxCoordinate(), robot.getCoordinates().getxCoordinate());
                    break;
                case WEST:
                    assertEquals(new Coordinates(2,3).getxCoordinate(), robot.getCoordinates().getxCoordinate());
                    break;
                case NORTH:
                    assertEquals(new Coordinates(3,3).getyCoordinate(), robot.getCoordinates().getyCoordinate());
                    break;
                case SOUTH:
                    assertEquals(new Coordinates(3,2).getyCoordinate(), robot.getCoordinates().getyCoordinate());
                    break;
                default:
                    break;
            }
        });
    }


    @Test
    public void testLocation() throws IOException{
        Arrays.stream(DIRECTION.values()).forEach(direction -> {
            robot.setDirection(direction);
            controller.location();
            switch (direction){
                case EAST:
                    assertEquals("2,2 EAST", baos.toString().trim());
                    baos.reset();
                    break;
                case WEST:
                    assertEquals("2,2 WEST", baos.toString().trim());
                    baos.reset();
                    break;
                case NORTH:
                    assertEquals("2,2 NORTH", baos.toString().trim());
                    baos.reset();
                    break;
                case SOUTH:
                    assertEquals("2,2 SOUTH", baos.toString().trim());
                    baos.reset();
                    break;
                default:
                    break;
            }
        });

    }


}
