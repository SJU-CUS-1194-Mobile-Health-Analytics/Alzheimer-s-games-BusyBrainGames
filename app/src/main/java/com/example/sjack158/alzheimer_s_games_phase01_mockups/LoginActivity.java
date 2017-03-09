package com.example.sjack158.alzheimer_s_games_phase01_mockups;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;


public class LoginActivity extends Activity
{
    
    Button login, forgotpass, signup;
    EditText usernameEdit, passwordEdit;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.LoginButton);
        usernameEdit = (EditText) findViewById(R.id.EnterNameText);
        passwordEdit = (EditText) findViewById(R.id.EnterPasswordText);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (usernameEdit.getText().toString().equals("Name") &&
                        passwordEdit.getText().toString().equals("Password"))
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

        forgotpass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this , ForgotPassActivity.class);
                //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)
                startActivity(intent);


            }
        });
    }
}

