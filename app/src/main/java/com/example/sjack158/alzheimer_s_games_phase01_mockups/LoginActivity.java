package com.example.sjack158.alzheimer_s_games_phase01_mockups;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends Activity
{

    public String email;
    public String userID;
    UserGameTransaction game01= new UserGameTransaction(userID, email);
    private DatabaseReference mDatabase;

    private static final String TAG = "EmailPassword";
    private FirebaseAnalytics mFirebaseAnalytics;
    Button login, forgotpass, signup;
    EditText EmailEdit, passwordEdit;

    //Start declare_auth
    private FirebaseAuth mAuth;
    //Start declare_auth_listener
    private FirebaseAuth.AuthStateListener mAuthListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        //Views && Buttons
        login = (Button) findViewById(R.id.LoginButton);
        forgotpass = (Button) findViewById(R.id.ForgotButton);
        signup = (Button) findViewById(R.id.SignUpButton);
        EmailEdit = (EditText) findViewById(R.id.EnterEmailText);
        passwordEdit = (EditText) findViewById(R.id.EnterPasswordText);

        //initializing firebase auth object
        mAuth = FirebaseAuth.getInstance();

        //Start auth_state_listener
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                if (user != null)
                {
                    // User is signed in

                    userID = user.getUid();
                    email = user.getEmail();
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                updateUI(user);
            }
        }; //End auth_state_listener

        //Once the user clicks the login button....
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    signIn(EmailEdit.getText().toString(), passwordEdit.getText().toString());
                //Sending User Information to Database
                    //submitUserGameData();

               // }




            }


        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)
                startActivity(intent);


            }
        });


        forgotpass.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassActivity.class);
                //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)
                startActivity(intent);


            }
        });
    }

    public void submitUserGameData()
    {
        Toast.makeText(this, "Posting Your Profile Information...", Toast.LENGTH_SHORT).show();
        //UserGameTransaction game01 = new UserGameTransaction();
        game01.setUid(userID);
        game01.setEmail(email);

        //mDatabase.child("users").child(userID).child("userInformation").child(email);

        mDatabase.child("users").child(userID).setValue(userID);
        mDatabase.child("users").child(userID).child("Email Address").setValue(email);
    }

    @Override
    public void onStart() {
        super.onStart();
       // mAuth.addAuthStateListener(mAuthListener);
        FirebaseUser currentUser=  mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void signIn(String email, String password)
    {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm())
        {
            return;
        }

        //showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        // [START_EXCLUDE]
                        if (task.isSuccessful())
                        {
                            Log.d(TAG, "signInWithEmail:onComplete:");
                            Toast.makeText(LoginActivity.this, "Successful!",
                                    Toast.LENGTH_SHORT).show();


                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                            //Intent intent = new Intent(CurrentActivity.this, NextActivity.class)
                            startActivity(intent);
                            updateUI(user);


                        }
                        else
                        {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(LoginActivity.this, "Incorrect Email Address",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }


                        //hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = EmailEdit.getText().toString();
        if (TextUtils.isEmpty(email)) {
            EmailEdit.setError("Required.");
            valid = false;
        } else {
            EmailEdit.setError(null);
        }

        String password = passwordEdit.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passwordEdit.setError("Required.");
            valid = false;
        } else {
            passwordEdit.setError(null);
        }

        return valid;
    }

    private void updateUI(FirebaseUser user) {
        // hideProgressDialog();
        if (user != null) {
//            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
//                    user.getEmail(), user.isEmailVerified()));
//             mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.EnterPasswordText).setVisibility(View.VISIBLE);
            findViewById(R.id.EnterEmailText).setVisibility(View.VISIBLE);
            findViewById(R.id.LoginButton).setVisibility(View.VISIBLE);

            //findViewById(R.id.verify_email_button).setEnabled(!user.isEmailVerified());
        } else {
//            mStatusTextView.setText(R.string.signed_out);
//            mDetailTextView.setText(null);

            findViewById(R.id.EnterPasswordText).setVisibility(View.VISIBLE);
            findViewById(R.id.EnterEmailText).setVisibility(View.VISIBLE);
            findViewById(R.id.LoginButton).setVisibility(View.VISIBLE);
        }
    }


}


