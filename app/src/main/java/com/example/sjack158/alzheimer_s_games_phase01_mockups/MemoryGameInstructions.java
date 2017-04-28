package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by sjack158 on 4/24/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CelesteG on 4/19/17.
 */

public class MemoryGameInstructions extends AppCompatActivity {
    Button button;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_instructions);

        button = (Button) findViewById(R.id.buttoncont);
        back = (Button) findViewById(R.id.buttonbacktodash);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryGameInstructions.this, MemoryLevels.class);
                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryGameInstructions.this, DashboardActivity.class);
                startActivity(intent);

            }
        });

    }



}



