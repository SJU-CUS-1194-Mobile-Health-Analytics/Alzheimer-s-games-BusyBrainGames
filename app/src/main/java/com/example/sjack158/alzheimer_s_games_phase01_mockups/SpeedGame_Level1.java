package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by CelesteG on 5/1/17.
 */

public class SpeedGame_Level1 extends AppCompatActivity{
    Button[] buttons = new Button[9];
    TextView textView_message;
    TextView movesView;
    int size = 9;
    int moves;
    Button back;
    TextView message;
    Date date= new Date();
    String datetime=date.toString();
    GameScore score;

    Game game = new Game(buttons, textView_message);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_level1);
        back = (Button) findViewById(R.id.ReturnButt);
        score = new GameScore(datetime, moves);


        game.buttons[0] = (Button) findViewById(R.id.button1);
        game.buttons[1] = (Button) findViewById(R.id.button2);
        game.buttons[2] = (Button) findViewById(R.id.button3);
        game.buttons[3] = (Button) findViewById(R.id.button4);
        game.buttons[4] = (Button) findViewById(R.id.button5);
        game.buttons[5] = (Button) findViewById(R.id.button6);
        game.buttons[6] = (Button) findViewById(R.id.button7);
        game.buttons[8] = (Button) findViewById(R.id.button9);


        game.buttons[7] = (Button) findViewById(R.id.button8);
        //initialize();
        game.message = (TextView) findViewById(R.id.textView_message);


    }

    public void clickNewGame(View v) {
        game.startNewGame();
    }

    public void clickSliderTile(View tile) {
        game.tryToMoveTile(tile);
        score.setScore(game.getMoves());
        ((TextView) findViewById(R.id.Moves)).setText("Moves: " + score.getScore());


    }


    public void initialize() {
        for (int i = 0; i < size; i++)
            game.buttons[i].setClickable(false);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Speed_Levels.class);
        startActivity(intent);
    }

    private void gameOver() {
        message.setText("Replay Game or play next level!");


    }

    public String getScoreInfo(GameScore scores)
    {
        return "Date: " + scores.getTime() +" "+ "Moves: " +  scores.getScore();
    }
}

