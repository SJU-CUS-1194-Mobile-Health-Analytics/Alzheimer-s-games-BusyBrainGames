package com.example.sjack158.alzheimer_s_games_phase01_mockups;
import android.widget.Button;

/**
 * Created by CelesteG on 4/19/17.
 */

public class MemoryGameCard {


    public int x;
    public int y;
    public Button button;

    public MemoryGameCard(Button button, int x, int y) {
        this.x = x;
        this.y = y;
        this.button = button;
    }
}
