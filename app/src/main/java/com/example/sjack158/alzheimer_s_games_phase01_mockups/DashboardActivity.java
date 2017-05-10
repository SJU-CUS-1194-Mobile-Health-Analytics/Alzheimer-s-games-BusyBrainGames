package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DashboardActivity extends Activity

{


    //Start declare_auth
    private FirebaseAuth mAuth;
    //Start declare_auth_listener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dashboard);


        //initializing firebase auth object
        mAuth = FirebaseAuth.getInstance();

          /*
        TODO: SAMPLE: Test the Firebase Database via a random test. Author: Lily :)
        UserProfileData userProfile = new UserProfileData();
        userProfile.name = "Lily";
        userProfile.age = 19;
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference();
        ref.child("bananas").child("apple").child("coConut").setValue(userProfile);
        Log.d("DB TRY!!!","Access");
    */

        /*TODO: After user logs in, their information will be sent to the FireBase database
           when he or she reaches the the dashboard page
        */

        UserProfileData userProfile = new UserProfileData();
        userProfile.setUid(mAuth.getCurrentUser().getUid());
        userProfile.setEmail(mAuth.getCurrentUser().getEmail());

        FirebaseDatabase userDB = FirebaseDatabase.getInstance().getInstance();
        DatabaseReference ref = userDB.getReference();
        ref.child("login_users").child("userID").setValue(userProfile.getUid());
        ref.child("login_users").child("userID").child(userProfile.getUid()).child("email").setValue(userProfile.getEmail());

        Log.d("ACTION: LOGIN INFO","FIREBASE DB Access");





        ImageButton but = (ImageButton)findViewById(R.id.memorybutton);
        ImageButton but02 = (ImageButton)findViewById(R.id.speedbutton);
        ImageButton profile= (ImageButton) findViewById(R.id.profilebutton);
        ImageButton attention=(ImageButton) findViewById(R.id.attentionbutton);

        Button signOut =(Button)findViewById(R.id.signOutButton);

        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Loading Instructions Page",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, MemoryGameInstructions.class);
                startActivity(intent);
            }

        }   );

        signOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Signing Out",
                        Toast.LENGTH_SHORT).show();
                signOut();
                Intent intent = new Intent(DashboardActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        }   );
        but02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Loading Instructions Page",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, Speed_Instructions.class);
                startActivity(intent);
            }

        }   );
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Loading Profile",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }

        }   ); attention.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Loading Instructions Page",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, Attention_Instructions.class);
                startActivity(intent);
            }

        }   );


    }



    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }
}
