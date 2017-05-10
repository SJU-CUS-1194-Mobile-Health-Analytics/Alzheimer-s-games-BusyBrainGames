package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


/**
 * Created by CelesteG on 5/1/17.
 */

public class AttentionLevels extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button backButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention_levels);

        button1 = (Button) findViewById(R.id.level1button);
        backButt = (Button) findViewById(R.id.rebutt);
        button2=(Button) findViewById(R.id.level2button);
        button3=(Button) findViewById(R.id.level3button);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(AttentionLevels.this, Attention_Level1.class);
                startActivity(intent);

            }
        });
        backButt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(AttentionLevels.this, Attention_Instructions.class);
                startActivity(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(AttentionLevels.this, Attention_Level2.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(AttentionLevels.this, Attention_Level3.class);
                startActivity(intent);

            }
        });



    }


}
