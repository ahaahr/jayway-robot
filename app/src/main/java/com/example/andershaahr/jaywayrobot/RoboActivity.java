package com.example.andershaahr.jaywayrobot;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


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

    }


}
