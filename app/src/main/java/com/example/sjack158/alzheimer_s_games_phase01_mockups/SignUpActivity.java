package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by tian9 on 3/6/2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button but = (Button)findViewById(R.id.button2);

        but.setOnClickListener(new View.OnClickListener()
                               {
                                   public void onClick(View v) {
                                       Intent intent = new Intent(SignUpActivity.this, ConfirmationActivity.class);

                                       startActivity(intent);

                                   }
                               }

        );
    }
}