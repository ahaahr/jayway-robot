package net.haahr.jaywayrobot.mvc;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.haahr.jaywayrobot.R;
import net.haahr.jaywayrobot.robot.RoboControlInterface;
import net.haahr.jaywayrobot.util.RoboPoint;
import net.haahr.jaywayrobot.util.RoboVector2D;

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

    private Activity activity;

    /**
     * UI elements
     */
    private Spinner directionSpinner;

    private EditText gridSizeXView;
    private EditText gridSizeYView;

    private EditText startXView;
    private EditText startYView;

    private TextView instructionsView;

    private TextView resultView;


    public RoboController(RoboControlInterface roboInterface, Activity activity){
        this.activity = activity;
        this.roboControlInterface = roboInterface;
        this.model = new RoboModel();

    }


    public void setListeners(){
        //set click listeners for start and clear buttons
        activity.findViewById(R.id.start_button).setOnClickListener(onStartClickListener);
        activity.findViewById(R.id.clear_button).setOnClickListener(onClearClickListener);

        //set click listener for the instructions buttons
        activity.findViewById(R.id.forward_button).setOnClickListener(onForwardInstructionClickListener);
        activity.findViewById(R.id.instruction_left).setOnClickListener(onLeftInstructionClickListener);
        activity.findViewById(R.id.instruction_right).setOnClickListener(onRightInstructionClickListener);
    }

    public void loadUIElements(){

        //load EditText elements for the grid size input
        gridSizeXView = (EditText) activity.findViewById(R.id.grid_max_x);
        gridSizeYView = (EditText) activity.findViewById(R.id.grid_max_y);

        //load EditTextElements for the robot starting positions
        startXView = (EditText) activity.findViewById(R.id.start_x);
        startYView = (EditText) activity.findViewById(R.id.start_y);

        //Load the spinner element for direction choice and set the adapter
        directionSpinner = (Spinner) activity.findViewById(R.id.direction_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(activity,
                R.array.directions_labels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        directionSpinner.setAdapter(adapter);

        //load the instructions view
        instructionsView = (TextView) activity.findViewById(R.id.instructions_view);

        //load the result view
        resultView = (TextView) activity.findViewById(R.id.result_view);
    }


    private void updateInstructionsView(){
        instructionsView.setText(model.getInstructions().toString());
    }


    private void updateResultView(String result){
        resultView.setText(result);
    }


    private final View.OnClickListener onStartClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            try {
                //set the grid size in the model object
                model.setSizeX(Integer.parseInt(gridSizeXView.getText().toString()));
                model.setSizeY(Integer.parseInt(gridSizeYView.getText().toString()));

                //set the start position in the model object
                RoboPoint startPosition = new RoboPoint(Integer.parseInt(startXView.getText().toString()), Integer.parseInt(startYView.getText().toString()));
                model.setStartPosition(startPosition);

                //determine user start direction selection
                String direction = directionSpinner.getSelectedItem().toString();
                RoboVector2D directionVector;

                switch (direction){
                    case "North":
                        directionVector = new RoboVector2D(0, -1);
                        break;
                    case "East":
                        directionVector = new RoboVector2D(1, 0);
                        break;
                    case "South":
                        directionVector = new RoboVector2D(0, 1);
                        break;
                    case "West":
                        directionVector = new RoboVector2D(-1, 0);
                        break;
                    default:
                        directionVector = new RoboVector2D(1, 0);
                        break;
                }

                //set the start direction in the model
                model.setStartDirection(directionVector);

                //start the robot
                RoboPoint result = roboControlInterface.start(model);
                updateResultView(result.toString());

            }
            catch (NumberFormatException numberFormatException){
                Toast.makeText(activity, "All input fields must be numbers", Toast.LENGTH_LONG).show();
            }
            catch (IllegalArgumentException illegalArgumentException){
                Toast.makeText(activity, illegalArgumentException.getMessage(), Toast.LENGTH_LONG).show();
            }

        }

    };


    private final View.OnClickListener onClearClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            model.clearInstructions();
            updateInstructionsView();
            resultView.setText("");
        }
    };


    private final View.OnClickListener onForwardInstructionClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            model.addInstruction("F");
            updateInstructionsView();
        }

    };


    private final View.OnClickListener onLeftInstructionClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            model.addInstruction("L");
            updateInstructionsView();
        }

    };


    private final View.OnClickListener onRightInstructionClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            model.addInstruction("R");
            updateInstructionsView();
        }
    };

}
