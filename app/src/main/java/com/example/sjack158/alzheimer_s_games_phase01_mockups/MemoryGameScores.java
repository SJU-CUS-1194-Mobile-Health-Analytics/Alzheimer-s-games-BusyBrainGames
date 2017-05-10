package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by CelesteG on 5/6/17.
 */

public class MemoryGameScores extends AppCompatActivity{


    private Button backtoPro;

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.memory_scores);

        backtoPro=(Button) findViewById(R.id.backtoProfile);
        backtoPro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MemoryGameScores.this, UserProfileActivity.class);
                startActivity(intent);



            }
        });



}
}
