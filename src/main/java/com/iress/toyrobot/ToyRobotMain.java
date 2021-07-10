package com.iress.toyrobot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ToyRobotMain {

    public static void main(String[] args) throws Exception {
        ToyRobotMain main = new ToyRobotMain();
        main.run(args);
    }

    public void run(String[] args){
        if (args.length > 0)
        {
            BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/" + args[0])));

            Scanner inputScanner = new Scanner(txtReader);
            System.out.println(String.format("Processing file %s", args[0]));
            Robot toyRobot = new Robot();
            RobotController controller = new RobotController(toyRobot);
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
        }
        else
        {
            System.out.println("No input found");
        }
    }
}
