package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sjack158 on 3/6/2017.
 */

    public class HomeActivity extends AppCompatActivity
    {
        public TextView tv;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);


            tv=(TextView)findViewById(R.id.AppTitle);
            Button but = (Button)findViewById(R.id.PatientButton);

            but.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(HomeActivity.this , LoginActivity.class);
                    //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            "Loading Login Page...", Toast.LENGTH_SHORT).show();
                }
            });

            Button but02 = (Button)findViewById(R.id.AdminButton);

            but02.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent = new Intent(HomeActivity.this , AdminLoginActivity.class);
                    //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            "Loading Login Page...", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

