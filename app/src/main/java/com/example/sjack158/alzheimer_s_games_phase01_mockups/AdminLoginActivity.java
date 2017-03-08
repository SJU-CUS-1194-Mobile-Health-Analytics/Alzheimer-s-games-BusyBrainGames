package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sjack158 on 3/6/2017.
 */

public class AdminLoginActivity extends Activity {
    EditText enterAdminID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        enterAdminID = (EditText) findViewById(R.id.EnterAdminID);
        Button AdminLog = (Button) findViewById(R.id.AdminLoginButton);

        AdminLog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (enterAdminID.getText().toString().equals("XYZ"))
                {
                    /*
                        A toast provides simple feedback about an operation in a small popup.
                        It only fills the amount of space required for the message and the current
                        activity remains visible and interactive.

                    */
                    Toast.makeText(getApplicationContext(),
                            "Loading Dashboard...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Wrong Credentials..",Toast.LENGTH_SHORT).show();



                }
            }
        });

        Button but05 = (Button)findViewById(R.id.ForgotAdminIDButton);

        but05.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)


                Toast.makeText(getApplicationContext(),
                        " OH SNAP! Please Contact Healthcare Facility Manager...", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
