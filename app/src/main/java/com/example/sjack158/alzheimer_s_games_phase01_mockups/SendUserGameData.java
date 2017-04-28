package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by sjack158 on 4/26/2017.
 */

/*
   TODO:Import Information for Firebase Database
*/

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.Map;


public class SendUserGameData {
    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    UserGameTransaction game01 = new UserGameTransaction();

    public void submitUserGameData() {
        //Toast.makeText(this.MemoryGame_Level1, "Posting Your Results...", Toast.LENGTH_SHORT).show();
        //UserGameTransaction game01 = new UserGameTransaction();
        final String userID = game01.getUid();
        final String email = game01.getEmail();
        final int level = game01.getLevel();
        String levelAsString = Integer.toString(level);
        final int turns = game01.getTurns();
        String turnsAsString = Integer.toString(turns);
        final String timestamp = game01.getTimeStamp();

        mDatabase.child("users").child(userID).child("userInformation").child(email);
    }
}