package net.haahr.jaywayrobot.mvc;

import net.haahr.jaywayrobot.util.RoboPoint;
import net.haahr.jaywayrobot.util.RoboVector2D;

import java.util.ArrayList;

/**
 * Created by anders.haahr on 05/01/15.
 * The model part of the MVC pattern. Used to store data input from the UI
 */
public class RoboModel {

    private ArrayList<String> instructions;

    private RoboPoint startPosition;

    private RoboVector2D startDirection;

    private int sizeX;

    private int sizeY;


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
     * @return the instructions list for the robot
     */
    public ArrayList<String> getInstructions(){
        return this.instructions;
    }


    /**
     * Clears the instruction list
     */
    public void clearInstructions(){
        this.instructions.clear();
    }


    /**
     * @param startPosition The starting position for the robot in the grid
     */
    public void setStartPosition(RoboPoint startPosition){
        this.startPosition = startPosition;
    }


    /**
     * @return the starting position for the robot in the grid
     */
    public RoboPoint getStartPosition(){
        return this.startPosition;
    }


    /**
     * @param startDirection The starting direction for the robot, where (1, 0) is east, (0, 1) is south, (-1, 0) is east and (0, -1) is north
     */
    public void setStartDirection(RoboVector2D startDirection){
        this.startDirection = startDirection;
    }


    /**
     * @return the starting direction for the robot, where (1, 0) is east, (0, 1) is south, (-1, 0) is east and (0, -1) is north
     */
    public RoboVector2D getStartDirection(){
        return this.startDirection;
    }


    /**
     * @param sizeX The horizontal size of the grid
     */
    public void setSizeX(int sizeX){
        this.sizeX = sizeX;
    }


    /**
     * @return The horizontal size of the grid
     */
    public int getSizeX(){
        return this.sizeX;
    }


    /**
     * @param sizeY The vertical size of the grid
    */
    public void setSizeY(int sizeY){
        this.sizeY = sizeY;
    }


    /**
     * @return The vertical size of the grid
     */
    public int getSizeY(){
        return this.sizeY;
    }

}
