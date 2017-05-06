package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by CelesteG on 5/1/17.
 */

public class Attention_Level1 extends AppCompatActivity{
    Button Button1;
    Button Button2;
    Button Button3;
    Button Button4;
    Button back;

    TextView color;
    TextView gameScore;
    int numOfQuestions;
    Boolean correct=false;
    int score;
    Date date= new Date();
    String datetime=date.toString();
    GameScore Attentionscore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention_level1);

        gameScore= (TextView) findViewById(R.id.textView5) ;
        color=(TextView) findViewById(R.id.color);
        score=0;
        setUpColor();
        Attentionscore = new GameScore(datetime, score);



        back = (Button)findViewById(R.id.returnbutt);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Attention_Level1.this, AttentionLevels.class);
                startActivity(intent);
            }
        });

        Button1 = (Button)findViewById(R.id.Button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(Button1);
                ((TextView) findViewById(R.id.textView5)).setText("Score:" + getScore());
            }
        });

        Button2 = (Button)findViewById(R.id.Button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(Button2);
                ((TextView) findViewById(R.id.textView5)).setText("Score:" + getScore());
            }

        });

        Button3 = (Button)findViewById(R.id.Button3);
        Button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(Button3);
                ((TextView) findViewById(R.id.textView5)).setText("Score:" + getScore());
            }

        });

        Button4 = (Button)findViewById(R.id.Button4);
        Button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(Button4);
                ((TextView) findViewById(R.id.textView5)).setText("Score:" + getScore());
            }

        });


    }

    public void setUpColor()
    {
        int [] colors = new int[]
                {
                        Color.RED, Color.BLUE, Color.CYAN, Color.BLACK
                };

        String[] texts = new String[]
                {
                        "RED","BLUE","CYAN","BLACK"
                };

        String text = texts[randString(0,texts.length)];

        int c= colors[randInt(0,colors.length)];

        color.setText("" + text);
        for (int j = 0;j < colors.length; j++)
        {
            color.setTextColor(c);
        }



    }

    public static int randInt(int min, int max)
    {
        Random rand= new Random();
        int randomNum = rand.nextInt((max-min)) +min;
        return randomNum;
    }

    public static int randString(int min, int max)
    {
        Random rand= new Random();
        int randomNum = rand.nextInt((max-min)) +min;
        return randomNum;
    }

    public void isMatching(Button Button)
    {
        if (color.getCurrentTextColor() == Color.RED && Button.getText().equals("RED")) {
            correct = true;
            Toast.makeText(Attention_Level1.this, "CORRECT!", Toast.LENGTH_LONG).show();
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.BLUE && Button.getText().equals("BLUE")) {
            Toast.makeText(Attention_Level1.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;

            }
            setUpColor();
            numOfQuestions++;

        } else if (color.getCurrentTextColor() == Color.CYAN && Button.getText().equals("CYAN")) {
            Toast.makeText(Attention_Level1.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;

        } else if (color.getCurrentTextColor() == Color.BLACK && Button.getText().equals("BLACK")) {
            Toast.makeText(Attention_Level1.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else {
            Toast.makeText(Attention_Level1.this, "INCORRECT.", Toast.LENGTH_LONG).show();
            correct = false;
            if (correct = true) {
                color.setText("");
            }
            setUpColor();
            numOfQuestions++;
        }

        if(numOfQuestions==10)
        {
            endGame();
            ((TextView) findViewById(R.id.color)).setText("Final Score: " + getScore());
            ((TextView) findViewById(R.id.textView4)).setText("Game Over!!");


        }

    }
    public void onClick(View v) {
        Intent intent = new Intent(this, AttentionLevels.class);
        startActivity(intent);
    }

    public int getScore()
    {
        return score;
    }



    public void endGame()
    {
            Button1.setClickable(false);
            Button2.setClickable(false);
            Button3.setClickable(false);
            Button4.setClickable(false);

    }
    public String getScoreInfo(GameScore scores)
    {
        return "Level 1" + " Date: " + scores.getTime() +" "+ "Moves: " +  getScore();
    }


//    public void goTo()
//    {
//        Intent intent = new Intent(Level1Activity.this, level2.class);
//        startActivity(intent);
//    }

}



