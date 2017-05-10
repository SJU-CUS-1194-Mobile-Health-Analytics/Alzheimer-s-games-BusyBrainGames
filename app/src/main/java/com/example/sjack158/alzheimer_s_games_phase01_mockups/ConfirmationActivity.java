package com.example.sjack158.alzheimer_s_games_phase01_mockups;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by tian9 on 3/6/2017.
 */

public class ConfirmationActivity extends Activity {

    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();





        Button goBackLoginPage= (Button) findViewById(R.id.backlogin);


        goBackLoginPage.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(ConfirmationActivity.this, LoginActivity.class);
                startActivity(intent);

            }
});
    }
}
