package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import java.util.Date;

/**
 * Created by sjack158 on 5/6/2017.
 */

//TODO: Category: Speed Game. Displays the user's game information
public class SpeedGameData
{
    public String email;
    public int level;
    public int score;
    Date date = new Date();
    String timeStamp = date.toString();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
