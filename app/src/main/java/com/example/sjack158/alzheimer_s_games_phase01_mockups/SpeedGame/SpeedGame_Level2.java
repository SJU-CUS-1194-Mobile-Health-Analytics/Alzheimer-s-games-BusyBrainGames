package com.example.sjack158.alzheimer_s_games_phase01_mockups.SpeedGame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sjack158.alzheimer_s_games_phase01_mockups.GameScore;
import com.example.sjack158.alzheimer_s_games_phase01_mockups.R;

import java.util.Date;

/**
 * Created by CelesteG on 5/1/17.
 */

public class SpeedGame_Level2 extends AppCompatActivity{
    Button[] buttons = new Button[12];
    TextView textView_message;
    TextView movesView;
    int size = 12;
    int moves;
    Button back;
    Button next;
    Date date= new Date();
    String datetime=date.toString();
    GameScore score;

    Game2 game = new Game2( buttons, textView_message);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_level2);

        score = new GameScore(datetime, moves);

        game.buttons[0] = (Button) findViewById(R.id.button1);
        game.buttons[1] = (Button) findViewById(R.id.button2);
        game.buttons[2] = (Button) findViewById(R.id.button3);
        game.buttons[3] = (Button) findViewById(R.id.button4);
        game.buttons[4] = (Button) findViewById(R.id.button5);
        game.buttons[5] = (Button) findViewById(R.id.button6);
        game.buttons[6] = (Button) findViewById(R.id.button7);
        game.buttons[7] = (Button) findViewById(R.id.button8);
        game.buttons[8] = (Button) findViewById(R.id.button9);
        game.buttons[9] = (Button) findViewById(R.id.button10);
        game.buttons[11] = (Button) findViewById(R.id.button12);



        // your button:
        // -----------------------------------------------------
        // Delete the "//" to add it to the list above!

        game.buttons[10] = (Button) findViewById(R.id.button11);

        //initialize();
        game.message = (TextView) findViewById(R.id.textView_message);


//        back= (Button) findViewById(R.id.ReturnButt) ;
//
//        back= (Button) findViewById(R.id.ReturnButt) ;
//        next=(Button) findViewById(R.id.button16);
//
//        back.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent intent = new Intent(SpeedGame_Level2.this, Speed_Instructions.class);
//                startActivity(intent);
//
//            }
//        });
//        next.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent intent = new Intent(SpeedGame_Level2.this, SpeedGame_Level3.class);
//                startActivity(intent);
//            }
//        });



    }
    public void clickNewGame(View v)
    {
        game.startNewGame();
    }

    public void clickSliderTile(View tile)
    {
        game.tryToMoveTile(tile);
        score.setScore(game.getMoves());
        ((TextView) findViewById(R.id.Moves)).setText("Moves: " + score.getScore());

    }


    public void initialize()
    {
        for (int i = 0; i < size; i++)
            game.buttons[i].setClickable(false);
    }

    public void onClick( View v)
    {
        Intent intent = new Intent(this, Speed_Levels.class);
        startActivity(intent);
    }
    public String getScoreInfo(GameScore scores)
    {
        return "Date: " + scores.getTime() +" "+ "Moves: " +  scores.getScore();
    }

}

