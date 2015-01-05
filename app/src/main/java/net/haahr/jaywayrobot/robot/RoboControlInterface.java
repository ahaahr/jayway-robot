package net.haahr.jaywayrobot.robot;

import net.haahr.jaywayrobot.util.RoboPoint;
import net.haahr.jaywayrobot.util.RoboVector2D;

import java.util.ArrayList;

/**
 * Created by anders.haahr on 05/01/15.
 * The instructions interface for the robot.
 * The implementing class should take care of the robot logic
 */
public interface RoboControlInterface {

    /**
     * Starts the robot. Executing the instructions from the queue. Throws an IllegalArgumentException
     * if the startingPosition is out of bounds of sizeX and sizeY for the grid
     * @param startPosition The starting position for the robot
     * @param startDirection The starting direction for the robot, where (1, 0) is east, (0, 1) is south, (-1, 0) is east and (0, -1) is north
     * @param sizeX The horizontal size of the grid
     * @param sizeY The vertical size of the grid
     * @throws IllegalArgumentException If the startPosition is out of bounds with sizeX or sizeY of the grid
     */
    void start(RoboPoint startPosition, RoboVector2D startDirection, int sizeX, int sizeY, ArrayList<String> instructions) throws IllegalArgumentException;

}
