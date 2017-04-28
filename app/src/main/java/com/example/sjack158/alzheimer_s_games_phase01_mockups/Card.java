package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by sjack158 on 4/24/2017.
 */

import android.widget.Button;



public class Card
{

    public int x;
    public int y;
    public Button button;

    public Card(Button button, int x,int y) {
        this.x = x;
        this.y=y;
        this.button=button;
    }


}
