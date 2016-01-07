package net.haahr.jaywayrobot.util;

/**
 * Created by anders.haahr on 05/01/15.
 * A point representing a position in a 2d coordinate system
 */
public class RoboPoint {

    public int x;
    public int y;

    public RoboPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public RoboPoint(RoboPoint point){
        this.x = point.x;
        this.y = point.y;
    }

    /**
     * Adds a RoboVector2D to this position and checks to make sure that the new point is not outside the bounds of (maxX, maxY)
     * @param vector The vector to add
     * @param maxX The maximum x value for the new position
     * @param maxY The maximum y value for the new position
     */
    public void add(RoboVector2D vector, int maxX, int maxY){
        int newX = this.x + vector.x;
        if(newX <= maxX && newX >= 0){
            this.x = newX;
        }

        int newY = this.y + vector.y;
        if(newY <= maxY && newY >= 0){
            this.y = newY;
        }
    }

}
