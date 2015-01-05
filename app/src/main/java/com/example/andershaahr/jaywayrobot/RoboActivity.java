package com.example.andershaahr.jaywayrobot;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import com.example.andershaahr.jaywayrobot.mvc.RoboController;
import com.example.andershaahr.jaywayrobot.robot.RoboState;


public class RoboActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robo);

        //since we do not need the action bar, hide it
        ActionBar actionBar = this.getActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        RoboState state = new RoboState();

        RoboController controller = new RoboController(state);
        controller.setListeners(this);

    }


}
