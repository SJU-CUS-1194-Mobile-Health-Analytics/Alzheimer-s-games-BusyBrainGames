package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by CelesteG on 4/29/17.
 */

public class GameScore {

    public int score;
    public Date date = new Date();
    //public String timeStamp=date.toString();

    public GameScore(String timeStamp, int score)
    {
        timeStamp=date.toString();
        score=0;
    }

    public void setScore(int score)
    {
        this.score=score;
    }
    public int getScore()
    {
        return score;
    }

//public void setTime(String time)
//{
//   this.time=time;
//}

public String getTime()
{
    return date.toString();
}

}
