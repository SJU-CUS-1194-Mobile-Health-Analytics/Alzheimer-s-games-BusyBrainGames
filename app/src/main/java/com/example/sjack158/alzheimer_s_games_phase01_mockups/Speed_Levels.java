package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by CelesteG on 5/1/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
/**
 * Created by CelesteG on 4/14/17.
 */

public class Speed_Levels extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_levels);

        button1 = (Button) findViewById(R.id.level1Button);
        backButton = (Button) findViewById(R.id.returnButton);
        button2=(Button) findViewById(R.id.level2Button);
        button3=(Button) findViewById(R.id.level3Button);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Speed_Levels.this, SpeedGame_Level1.class);
                startActivity(intent);

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Speed_Levels.this,Speed_Instructions.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Speed_Levels.this,SpeedGame_Level2.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Speed_Levels.this,SpeedGame_Level3.class);
                startActivity(intent);

            }
        });



    }

}
