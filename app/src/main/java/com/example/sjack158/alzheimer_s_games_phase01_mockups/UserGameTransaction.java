package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by sjack158 on 4/25/2017.
 */

public class UserGameTransaction
{

    public String uid;
    public String email;
    public int level;
    public int turns;
    public String timeStamp;


    public UserGameTransaction()
    {
        // TODO: Default constructor required for calls to DataSnapshot.getValue(UserGameTransaction.class)
    }

    public UserGameTransaction(String uid, String email, int level, int turns, String timeStamp)
    {
        this.uid=uid;
        this.email=email;
        this.level=level;
        this.turns=turns;
        this.timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public UserGameTransaction(String uid, String email)
    {
        this.uid=uid;
        this.email=email;
    }
    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public int getLevel() {
        return level;
    }

    public int getTurns() {
        return turns;
    }
    public String getTimeStamp()
    {
        timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
