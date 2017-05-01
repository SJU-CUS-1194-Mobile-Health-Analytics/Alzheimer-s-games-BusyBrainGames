package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity

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

        ImageButton but = (ImageButton)findViewById(R.id.memorybutton);
        ImageButton but02 = (ImageButton)findViewById(R.id.speedbutton);

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
    }



    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }
}