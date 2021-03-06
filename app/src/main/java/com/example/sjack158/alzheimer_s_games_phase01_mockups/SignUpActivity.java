package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by tian9 on 3/6/2017.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import static android.text.TextUtils.*;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener
{



    //private static final String TAG = "EmailPassword";

    //defining view objects
    private EditText editTextEmail;
        //editText id: editText3
    private EditText editTextPassword;
        //editTest id: editText5
    private ProgressDialog progressDialog;

    private EditText editTextFname;
    private EditText editTextLname;

    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;


    //private UserProfileData userExample;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();



        editTextEmail = (EditText) findViewById(R.id.editText3);
        editTextPassword = (EditText) findViewById(R.id.editText5);
        editTextFname = (EditText)  findViewById(R.id.editText);
        editTextLname = (EditText) findViewById(R.id.editText2);






        progressDialog = new ProgressDialog(this);













        Button but = (Button) findViewById(R.id.button2);

        but.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                if (user != null)
                {

                    Toast.makeText(SignUpActivity.this, "onAuthStateChanged:signed_in:",Toast.LENGTH_LONG).show();
                }
                else {
                    // User is signed out
                    Toast.makeText(SignUpActivity.this, "onAuthStateChanged:signed_out", Toast.LENGTH_LONG).show();
                }
                // ...
            }
        };


    }

    private void registerUser(){

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();


        //checking if email and passwords are empty
        if(isEmpty(email)){
            Toast.makeText(this,"Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if(isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(SignUpActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            Toast.makeText(SignUpActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });



    }

                                   public void onClick(View v) {
                                       //calling register method on click
                                       registerUser();


                                       sendProfileData();

                                       Intent intent = new Intent(SignUpActivity.this, ConfirmationActivity.class);

                                       startActivity(intent);


                                   }


    public void sendProfileData()
    {
        UserProfileData userProfile = new UserProfileData( );

        userProfile.setEmail(editTextEmail.getText().toString());
        userProfile.setFname(editTextFname.getText().toString());
        userProfile.setLname(editTextLname.getText().toString());
        FirebaseDatabase userDB = FirebaseDatabase.getInstance().getInstance();
        DatabaseReference ref = userDB.getReference();
        ref.child("users").child("email").setValue(userProfile.getEmail());
        ref.child("users")
                .child("email").child(userProfile.getEmail()).child("firstname").setValue(userProfile.getFname());
        ref.child("users")
                .child("email").child(userProfile.getEmail()).child("lastname").setValue(userProfile.getLname());

        Log.d("ACTION: SEND USER INFO","FIREBASE DB Access");
    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }
}

