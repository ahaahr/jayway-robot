package net.haahr.jaywayrobot.mvc;

import net.haahr.jaywayrobot.util.RoboPoint;
import net.haahr.jaywayrobot.util.RoboVector2D;

import java.util.ArrayList;

/**
 * Created by anders.haahr on 05/01/15.
 * The model part of the MVC pattern. Used to store data input from the UI
 */
public class RoboModel {

    /**
     * The list of instructions. The list has inner type String, but only the values 'F', 'L' and 'R' are valid
     */
    private ArrayList<String> instructions;


    public RoboModel(){
        instructions = new ArrayList<>();
    }


    /**
     * Adds an instruction to the instruction list
     * @param instruction The instruction to add
     */
    public void addInstruction(String instruction){
        instructions.add(instruction);
    }

    /**
     * @param startPosition The starting position for the robot
     */
    public void setStartPosition(RoboPoint startPosition){

    }

    /**
     * @param startDirection The starting direction for the robot, where (1, 0) is east, (0, 1) is south, (-1, 0) is east and (0, -1) is north
     */
    public void setStartDirection(RoboVector2D startDirection){

    }

    /**
     * @param sizeX The horizontal size of the grid
     */
    public void setSizeX(int sizeX){

    }

    /**
     * @param sizeY The vertical size of the grid
    */
    public void setSizeY(int sizeY){
        
    }

}
