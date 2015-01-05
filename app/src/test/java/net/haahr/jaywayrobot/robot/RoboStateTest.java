package net.haahr.jaywayrobot.robot;

import net.haahr.jaywayrobot.mvc.RoboModel;
import net.haahr.jaywayrobot.util.RoboPoint;
import net.haahr.jaywayrobot.util.RoboVector2D;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anders.haahr on 05/01/15.
 * Test class for the robots movement in the grid
 */
public class RoboStateTest {

    private RoboModel roboModel;
    private RoboState roboState;

    @Before
    public void setUp() throws Exception {
        roboModel = new RoboModel();
        roboModel.addInstruction("F");
        roboModel.setStartPosition(new RoboPoint(0, 0));
        roboModel.setStartDirection(new RoboVector2D(0, 1));
        roboModel.setSizeX(10);
        roboModel.setSizeY(10);

        roboState = new RoboState();
    }

    @Test
    public void testHorizontalMovementTest1(){
        RoboPoint result = roboState.start(roboModel);
        assertEquals(1, result.x);
    }
}