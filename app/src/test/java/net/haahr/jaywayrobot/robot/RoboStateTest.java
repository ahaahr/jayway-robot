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

    private RoboModel roboModel1x1;
    private RoboModel roboModel5x5;
    private RoboState roboState;

    @Before
    public void setUp() throws Exception {
        roboModel1x1 = new RoboModel();
        roboModel1x1.setStartPosition(new RoboPoint(0, 0));
        roboModel1x1.setStartDirection(new RoboVector2D(1, 0));
        roboModel1x1.setSizeX(1);
        roboModel1x1.setSizeY(1);

        roboModel5x5 = new RoboModel();
        roboModel5x5.setStartPosition(new RoboPoint(1, 1));
        roboModel5x5.setStartDirection(new RoboVector2D(1, 0));
        roboModel5x5.setSizeX(5);
        roboModel5x5.setSizeY(5);

        roboState = new RoboState();
    }

    @Test
    public void test1x1Grid(){
        roboModel1x1.addInstruction("F");
        RoboPoint result = roboState.start(roboModel1x1);
        assertEquals(0, result.x);
    }

    @Test
    public void testNoMovement(){
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(1, result.x);
        assertEquals(1, result.y);
    }

    @Test
    public void testMovement(){
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(2, result.x);
        assertEquals(1, result.y);
    }

    @Test
    public void testRightTurn(){
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(1, result.x);
        assertEquals(2, result.y);
    }

    @Test
    public void testLeftTurn(){
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(1, result.x);
        assertEquals(0, result.y);
    }

    @Test
    public void testLoop(){
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("R");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(1, result.x);
        assertEquals(1, result.y);
    }

    @Test
    public void testNorthBound(){
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(0, result.y);
    }

    @Test
    public void testEastBound(){
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(4, result.x);
    }

    @Test
    public void testSouthBound(){
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(4, result.y);
    }

    @Test
    public void testWestBound(){
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(0, result.x);
    }

    @Test
    public void testMultipleBounds(){
        //hit west bound, then north bound, then south bound
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(0, result.x);
        assertEquals(4, result.y);
    }

    @Test
    public void testEachCornerAndGotoCenter(){
        //hit each corner, then goto center
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("R");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("L");
        roboModel5x5.addInstruction("F");
        roboModel5x5.addInstruction("F");
        RoboPoint result = roboState.start(roboModel5x5);
        assertEquals(2, result.x);
        assertEquals(2, result.y);
    }


}