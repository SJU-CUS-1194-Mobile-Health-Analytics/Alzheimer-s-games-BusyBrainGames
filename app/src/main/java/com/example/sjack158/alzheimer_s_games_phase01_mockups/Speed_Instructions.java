package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by CelesteG on 5/1/17.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Speed_Instructions extends AppCompatActivity {

    Button button;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_instructions);

        button = (Button) findViewById(R.id.button);
        back = (Button) findViewById(R.id.button10);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Speed_Instructions.this, Speed_Levels.class);
                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Speed_Instructions.this, DashboardActivity.class);
                startActivity(intent);

            }
        });

    }}
