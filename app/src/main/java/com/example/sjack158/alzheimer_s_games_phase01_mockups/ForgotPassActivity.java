package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sjack158 on 3/8/2017.
 */

public class ForgotPassActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        Button but03 = (Button)findViewById(R.id.SendButton);

            but03.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {

                    //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)


                    Toast.makeText(getApplicationContext(),
                            " Check Email Inbox...", Toast.LENGTH_SHORT).show();
                }
        });
    }

}
