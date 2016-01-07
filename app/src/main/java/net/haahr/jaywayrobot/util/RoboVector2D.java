package net.haahr.jaywayrobot.util;

/**
 * Created by anders.haahr on 05/01/15.
 * A vector representing a direction for the robot to move.
 * The x value represents the horizontal direction and the y value represents the vertical directions.
 * Thus a RoboVector with values (1, 0) is pointing east and a RoboVector with values (0, -1) is pointing north (assuming (0, 0) is in the upper left).
 * Note that exactly one of the values in the vector must always be 0, since the robot cannot move diagonally, then other value must always be
 * either -1 or 1, since the robot always points in some direction.
 */
public class RoboVector2D {

    public int x;
    public int y;

    public RoboVector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public RoboVector2D(RoboVector2D vector){
        this.x = vector.x;
        this.y = vector.y;
    }

    public void setVector(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Turn left 90 degrees. Explanation of the turn logic:
     * Invariant: Exactly one of the vector values is always 0.
     * If we turn right four times, we will end up facing the same direction as we started,
     * thus we can make a turn loop, which looks like this:
     * (1, 0) R (0, -1) R (-1, 0) R (0, 1).
     * We can observe that when turning from a horizontal to a vertical direction the x and y values are switched and their sign are changed.
     * We can also observe that when turning from a vertical direction to a horizontal direction the x and y values are switch with no sign changes.
     */
    public void turnLeft(){
        if(y == 0){
            setVector(-y, -x);
        }
        else{
            setVector(y, x);
        }
    }

    /**
     * Turn right 90 degrees. Explanation of the turn logic:
     * The logic is similar to the turnLeft operation except the signs change when switch from vertical to horizontal direction.
     */
    public void turnRight(){
        if(x == 0){
            setVector(-y, -x);
        }
        else{
            setVector(y, x);
        }
    }

}
