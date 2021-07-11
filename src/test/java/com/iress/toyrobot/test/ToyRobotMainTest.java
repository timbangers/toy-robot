package com.iress.toyrobot.test;

import com.iress.toyrobot.ToyRobotMain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ToyRobotMain
 */
public class ToyRobotMainTest {
    ByteArrayOutputStream baos;
    ToyRobotMain toyRobotMain;

    @BeforeEach
    public void setup(){
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        toyRobotMain = new ToyRobotMain();
    }

    @Test
    public void testRunWithInvalidFileName(){
        toyRobotMain.run(new String[]{"samplefilethatdoesnotexist.txt"});
        assertEquals("No input found", baos.toString().trim());
        baos.reset();
    }

    @Test
    public void testRunWithNoArgs(){
        toyRobotMain.run(new String[]{});
        assertEquals("No input found", baos.toString().trim());
        baos.reset();

    }

    @Test
    public void testRunHappyPath(){
        toyRobotMain.run(new String[]{"robot.txt"});
        assertEquals("Processing file robot.txt\r\n" +
                "Robot placement at 3,3\r\n" +
                "Robot moving at direction SOUTH\r\n" +
                "Robot moving at direction SOUTH\r\n" +
                "Robot changed direction to EAST\r\n" +
                "3,1 EAST", baos.toString().trim());
        baos.reset();
    }
}
