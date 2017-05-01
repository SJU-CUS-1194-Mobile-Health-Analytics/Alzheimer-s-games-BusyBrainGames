package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by CelesteG on 5/1/17.
 */

public class SpeedGame_Level3 extends AppCompatActivity{
    Button[] buttons = new Button[15];
    TextView textView_message;
    TextView movesView;
    int size = 15;
    int moves;
    Button back;

    Game3 game = new Game3( buttons, textView_message);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_level3);
        back= (Button) findViewById(R.id.ReturnButt) ;

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
        game.buttons[10] = (Button) findViewById(R.id.button11);
        game.buttons[11] = (Button) findViewById(R.id.button12);
        game.buttons[12] = (Button) findViewById(R.id.button13);
        game.buttons[14] = (Button) findViewById(R.id.button15);


        // your button:
        // -----------------------------------------------------
        // Delete the "//" to add it to the list above!

        game.buttons[13] = (Button) findViewById(R.id.button14);

        //initialize();
        game.message = (TextView) findViewById(R.id.textView_message);




    }
    public void clickNewGame(View v)
    {
        game.startNewGame();
    }

    public void clickSliderTile(View tile)
    {
        game.tryToMoveTile(tile);
        ((TextView)findViewById(R.id.Moves)).setText("Moves: "+ game.getMoves());

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


}


