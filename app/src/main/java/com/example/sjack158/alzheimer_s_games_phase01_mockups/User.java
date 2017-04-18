package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjack158 on 4/5/2017.
 */

public class User {
    public String uid;

    public User(String uid)
    {
        this.uid=uid;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);


        return result;
    }
}
