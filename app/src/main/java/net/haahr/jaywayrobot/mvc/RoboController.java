package net.haahr.jaywayrobot.mvc;

import android.app.Activity;
import android.view.View;

import net.haahr.jaywayrobot.R;
import net.haahr.jaywayrobot.robot.RoboControlInterface;

import java.util.ArrayList;

/**
 * Created by anders.haahr on 05/01/15.
 * This class acts as the controller for the MVC of the robot UI.
 * It also holds references to the start values and the instructions, i.e. the models in MVC.
 * Furthermore it holds a reference to an object of type roboInterface in order to start the robot when the user presses the start button
 */
public class RoboController {

    /**
     * The robot control interface
     */
    private RoboControlInterface roboControlInterface;


    /**
     * The model in the MVC pattern. Holds the data to be used to start the robot.
     */
    private RoboModel model;


    public RoboController(RoboControlInterface roboInterface){
        this.roboControlInterface = roboInterface;
        this.model = new RoboModel();
    }


    public void setListeners(Activity activity){
        //set click listener for start button
        activity.findViewById(R.id.start_button).setOnClickListener(OnStartClickListener);
    }


    private final View.OnClickListener OnStartClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {



        }

    };


    private final View.OnClickListener onLeftInstructionClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            model.addInstruction("L");
        }

    };

}
