package com.iress.toyrobot.test;

import com.iress.toyrobot.Coordinates;
import com.iress.toyrobot.DIRECTION;
import com.iress.toyrobot.Robot;
import com.iress.toyrobot.Utilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {

    @Test
    public void testIsOnTable(){
        for (int i = 0; i <=4; i++){
            assertTrue(Utilities.isOnTable(i,i));
        }
   }

    @Test
    public void testIsOnTableUsingCoordinates(){
        for (int i = 0; i <=4; i++){
            Coordinates c = new Coordinates(i,i);
            assertTrue(Utilities.isOnTable(c));
        }
    }

    @Test
    public void testIsPlaced(){
        for (int i = 0; i <=4; i++){
            Robot r = new Robot();
            Coordinates c = new Coordinates(i,i);
            r.setCoordinates(c);
            assertTrue(Utilities.isPlaced(r));
        }
    }

    @Test
    public void testGetCoordinateFromInput(){
        for (int i = 0; i <=4; i++){
            assertEquals(i,Utilities.getCoordinateFromInput(String.format("PLACE %d,%d,SOUTH", i,i)).getyCoordinate());
            assertEquals(i,Utilities.getCoordinateFromInput(String.format("PLACE %d,%d,SOUTH", i,i)).getxCoordinate());
            assertNotEquals(-1,Utilities.getCoordinateFromInput(String.format("PLACE %d,%d,SOUTH", i,i)).getxCoordinate());
            assertNotEquals(-1,Utilities.getCoordinateFromInput(String.format("PLACE %d,%d,SOUTH", i,i)).getyCoordinate());

        }
    }

    @Test
    public void testGetDirectionFromInput(){
        assertEquals(DIRECTION.EAST,Utilities.getDirectionFromInput("PLACE 1,1,EAST"));
        assertEquals(DIRECTION.WEST,Utilities.getDirectionFromInput("PLACE 1,1,WEST"));
        assertEquals(DIRECTION.NORTH,Utilities.getDirectionFromInput("PLACE 1,1,NORTH"));
        assertEquals(DIRECTION.SOUTH,Utilities.getDirectionFromInput("PLACE 1,1,SOUTH"));
    }

    @Test
    public void testGetLocationFromInput(){
        String line = "PLACE 1,1,EAST";
        String[] lineArray = {"1", "1", "EAST"};
        assertEquals(lineArray[0],Utilities.getLocationFromInput(line)[0]);
        assertEquals(lineArray[1],Utilities.getLocationFromInput(line)[1]);
        assertEquals(lineArray[2],Utilities.getLocationFromInput(line)[2]);

    }
}


