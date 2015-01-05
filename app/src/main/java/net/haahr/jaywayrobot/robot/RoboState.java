package net.haahr.jaywayrobot.robot;

import net.haahr.jaywayrobot.mvc.RoboModel;
import net.haahr.jaywayrobot.util.RoboPoint;

/**
 * Created by anders.haahr on 05/01/15.
 * Implements the RoboControlInterface and keeps track of the robot's state during execution of instructions
 */
public class RoboState implements RoboControlInterface {


    @Override
    public RoboPoint start(RoboModel model) throws IllegalArgumentException {
        return new RoboPoint(1,0);
    }
}
