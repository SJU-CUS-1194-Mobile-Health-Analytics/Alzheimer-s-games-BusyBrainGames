package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjack158 on 3/25/2017.
 */

public class MemoryTurns
{


    public String turns;
    public String userID;


    public MemoryTurns( String userID, String turns) {

        this.userID = userID;
        this.turns = turns;
    }
    public String getTurns() {
        return turns;
    }

    public void setTurns(String turns) {
        this.turns = turns;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Map<String,Object> toMap()
    {
        HashMap<String,Object> result = new HashMap<>();
        result.put("userID", userID);
        result.put("turns",turns);


        return result;
    }
}

