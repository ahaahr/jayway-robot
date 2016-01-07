package net.haahr.jaywayrobot.robot;

import net.haahr.jaywayrobot.mvc.RoboModel;
import net.haahr.jaywayrobot.util.RoboPoint;
import net.haahr.jaywayrobot.util.RoboVector2D;

/**
 * Created by anders.haahr on 05/01/15.
 * Implements the RoboControlInterface and keeps track of the robot's state during execution of instructions
 */
public class RoboState implements RoboControlInterface {


    @Override
    public RoboPoint start(RoboModel model) throws IllegalArgumentException {

        //check to make sure the grid size is not negative
        if(model.getSizeX() < 1 || model.getSizeY() < 1){
            throw new IllegalArgumentException("Grid size must be at least 1x1");
        }

        //check to make sure the starting positions are inside the grid
        if(model.getStartPosition().x >= model.getSizeX() || model.getStartPosition().y >= model.getSizeY()){
            throw new IllegalArgumentException("Starting position is outside of the grid");
        }

        //create objects to store the robots position and direction during execution
        RoboPoint position = new RoboPoint(model.getStartPosition());
        RoboVector2D direction = new RoboVector2D(model.getStartDirection());

        //loop through the instructions and call the appropriate methods
        for(String instruction : model.getInstructions()){

            switch (instruction){
                case "F":
                    position.add(direction, model.getSizeX() - 1, model.getSizeY() - 1);
                    break;

                case "L":
                    direction.turnLeft();
                    break;

                case "R":
                    direction.turnRight();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown command in instruction list: " + instruction);
            }

        }

        return position;
    }
}
