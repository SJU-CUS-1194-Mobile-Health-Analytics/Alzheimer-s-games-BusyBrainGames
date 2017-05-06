package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by CelesteG on 5/1/17.
 */

public class Attention_Instructions extends AppCompatActivity {
    Button continueButton;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention_instructions);

        continueButton = (Button) findViewById(R.id.buttonToContinue);
        back = (Button) findViewById(R.id.buttonbacktodash);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Attention_Instructions.this, AttentionLevels.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Attention_Instructions.this, DashboardActivity.class);
                startActivity(intent);
            }
        });


//


    }

}




