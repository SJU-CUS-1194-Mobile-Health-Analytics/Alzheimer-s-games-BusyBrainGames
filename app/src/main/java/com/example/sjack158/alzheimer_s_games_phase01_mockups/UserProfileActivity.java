package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by CelesteG on 3/9/17.
 */

public class UserProfileActivity extends AppCompatActivity {

    private UserProfile profile;
    private TextView userFirstName;
    private TextView userLastName;
    private DatabaseReference userDatabase;
    private Button attenButton;
    private Button speedButton;
    private Button memoryButton;
    private Button returnButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        userFirstName=(TextView) findViewById(R.id.textView13);
        userLastName=(TextView)findViewById(R.id.textView18);

        attenButton = (Button) findViewById(R.id.attentionButt);
        speedButton = (Button) findViewById(R.id.button10);
        memoryButton=(Button) findViewById(R.id.button8);
        returnButton=(Button) findViewById(R.id.backtoDash);

        attenButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, AttentionGameScores.class);
                startActivity(intent);

            }
        });
        speedButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, SpeedGameScores.class);
                startActivity(intent);

            }
        });
        memoryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //UPDATE: CHANGED DIRECTION
                Intent intent = new Intent(UserProfileActivity.this, UserProfileGameResults.class);
                startActivity(intent);

            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, DashboardActivity.class);
                startActivity(intent);

            }
        });



    }


    private void intitalizeDatabase()
    {
        userDatabase = FirebaseDatabase.getInstance().getReference();
        userDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null)
                {
                    profile = dataSnapshot.getValue(UserProfile.class);
                    updateInfo();
                }
                else{
                    System.out.println("Error retrieving data ");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateInfo()
    {
        userFirstName.setText("" + profile.getFirstName() );
        userLastName.setText("" + profile.getLastName() );
    }




}