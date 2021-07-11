package com.iress.toyrobot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ToyRobotMain
 * This class is the entry point of the application. It reads a file containing commands which will give instructions to a toy robot
 */
public class ToyRobotMain {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        ToyRobotMain main = new ToyRobotMain();
        main.run(args);
    }

    /**
     * This method takes an argument in the form of filename, if none is given a message saying No input found is printed
     * @param args
     */
    public void run(String[] args){
        if (args.length > 0)
        {
            try{
                InputStreamReader is = new InputStreamReader(getClass().getResourceAsStream("/" + args[0]));
                BufferedReader txtReader = new BufferedReader(is);
                Scanner inputScanner = new Scanner(txtReader);
                System.out.println(String.format("Processing file %s", args[0]));
                ToyRobot toyRobot = new ToyRobot();
                ToyRobotController controller = new ToyRobotController(toyRobot);
                while (inputScanner.hasNext()){
                    String line = inputScanner.nextLine().toUpperCase();
                    if (line.contains(Constants.COMMAND_PLACE) && Utilities.isOnTable(Utilities.getCoordinateFromInput(line))){
                        controller.place(Utilities.getCoordinateFromInput(line), Utilities.getDirectionFromInput(line));
                        System.out.println(String.format("Robot placement at %s,%s", controller.getRobot().getCoordinates().getxCoordinate(), controller.getRobot().getCoordinates().getyCoordinate() ));;
                    } else if (line.contains(Constants.COMMAND_MOVE)){
                        controller.move();
                        System.out.println(String.format("Robot moving at direction %s", controller.getRobot().getDirection()));
                    } else if ((line.contains(Constants.COMMAND_TURN_LEFT) || line.contains(Constants.COMMAND_TURN_RIGHT))){
                        controller.turn(line);
                        System.out.println(String.format("Robot changed direction to %s", controller.getRobot().getDirection()));
                    } else if (line.contains(Constants.COMMAND_REPORT)){
                        controller.location();
                    }
                }
            } catch (Exception e){
                System.out.println("No input found");
            }
        }
        else
        {
            System.out.println("No input found");
        }
    }
}
