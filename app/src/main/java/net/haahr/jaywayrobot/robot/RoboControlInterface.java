package net.haahr.jaywayrobot.robot;

import net.haahr.jaywayrobot.mvc.RoboModel;

/**
 * Created by anders.haahr on 05/01/15.
 * The instructions interface for the robot.
 * The implementing class should take care of the robot logic
 */
public interface RoboControlInterface {

    /**
     * Starts the robot. Executing the instructions from the queue. Throws an IllegalArgumentException
     * if the startingPosition is out of bounds of sizeX and sizeY for the grid
     * @param model The RoboModel object containing the data necessary for the robot to start
     * @throws IllegalArgumentException If the startPosition is out of bounds with sizeX or sizeY of the grid
     */
    void start(RoboModel model) throws IllegalArgumentException;

}
