package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
/**
 * Created by CelesteG on 4/19/17.
 */

public class MemoryLevels extends AppCompatActivity {

    Button butt1;
    Button butt2;
    Button butt3;
    Button butt4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_levels);
        butt1 = (Button) findViewById(R.id.button2);
        butt2 = (Button) findViewById(R.id.button3);
        butt3 = (Button) findViewById(R.id.button4);
        butt4 = (Button) findViewById(R.id.buttonback);

        butt1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryLevels.this, MemoryGame_Level1.class);
                startActivity(intent);

            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryLevels.this, MemoryGame_Level2.class);
                startActivity(intent);

            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryLevels.this, MemoryGame_Level3.class);
                startActivity(intent);

            }
        });
        butt4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryLevels.this, MemoryGameInstructions.class);
                startActivity(intent);

            }
        });
    }
}