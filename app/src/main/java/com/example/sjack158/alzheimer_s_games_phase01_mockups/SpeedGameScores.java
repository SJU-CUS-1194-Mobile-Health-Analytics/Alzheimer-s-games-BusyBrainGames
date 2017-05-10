package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sjack158.alzheimer_s_games_phase01_mockups.MemoryGameScores;
import com.example.sjack158.alzheimer_s_games_phase01_mockups.R;
import com.example.sjack158.alzheimer_s_games_phase01_mockups.UserProfileActivity;

/**
 * Created by CelesteG on 5/6/17.
 */

public class SpeedGameScores extends AppCompatActivity {

    private Button backToProfile;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_scores);

        backToProfile=(Button) findViewById(R.id.returntoProfile);
        backToProfile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(SpeedGameScores.this, UserProfileActivity.class);
                startActivity(intent);

            }
        });



    }
}