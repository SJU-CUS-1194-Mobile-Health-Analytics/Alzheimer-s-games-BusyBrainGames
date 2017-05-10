package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by CelesteG on 5/1/17.
 */

public class Attention_Level2 extends AppCompatActivity {

    Button r2Button;
    Button b2Button;
    Button c2Button;
    Button bk2Button;
    Button m2Button;
    Button g2Button;
    Button back;
    TextView color;
    int numOfQuestions;
    TextView gameScore;
    Date date= new Date();
    String datetime=date.toString();
    GameScore Attentionscore;

    private FirebaseAuth mAuth;

    Boolean correct=false;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention_level2);

        mAuth = FirebaseAuth.getInstance();

        gameScore= (TextView) findViewById(R.id.textView6) ;
        Attentionscore = new GameScore(datetime, score);

        color=(TextView) findViewById(R.id.textView);
        score=0;
        setUpColor();
        back = (Button)findViewById(R.id.returnbutt);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Attention_Level2.this, AttentionLevels.class);
                startActivity(intent);
            }
        });
        r2Button = (Button)findViewById(R.id.r2Button);
        r2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(r2Button);
                ((TextView) findViewById(R.id.textView6)).setText("Score:" + getScore());
            }
        });

        b2Button = (Button)findViewById(R.id.b2Button);
        b2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(b2Button);
                ((TextView) findViewById(R.id.textView6)).setText("Score:" + getScore());
            }

        });

        c2Button = (Button)findViewById(R.id.c2Button);
        c2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(c2Button);
                ((TextView) findViewById(R.id.textView6)).setText("Score:" + getScore());
            }

        });

        bk2Button = (Button)findViewById(R.id.bk2Button);
        bk2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(bk2Button);
                ((TextView) findViewById(R.id.textView6)).setText("Score:" + getScore());
            }

        });

        m2Button = (Button)findViewById(R.id.m2Button);
        m2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(m2Button);
                ((TextView) findViewById(R.id.textView6)).setText("Score:" + getScore());
            }

        });

        g2Button = (Button)findViewById(R.id.g2Button);
        g2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(g2Button);
                ((TextView) findViewById(R.id.textView6)).setText("Score:" + getScore());
            }

        });

    }

    public void setUpColor()
    {
        int [] colors = new int[]
                {
                        Color.RED, Color.BLUE, Color.CYAN, Color.BLACK, Color.MAGENTA, Color.GREEN
                };

        String[] texts = new String[]
                {
                        "RED","BLUE","CYAN","BLACK","MAGENTA","GREEN"
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
            Toast.makeText(Attention_Level2.this, "CORRECT!", Toast.LENGTH_LONG).show();
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        }
        else if (color.getCurrentTextColor() == Color.BLUE && Button.getText().equals("BLUE")) {
            Toast.makeText(Attention_Level2.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;


        }
        else if (color.getCurrentTextColor() == Color.CYAN && Button.getText().equals("CYAN")) {
            Toast.makeText(Attention_Level2.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        }
        else if (color.getCurrentTextColor() == Color.BLACK && Button.getText().equals("BLACK")) {
            Toast.makeText(Attention_Level2.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        }
        else if (color.getCurrentTextColor() == Color.MAGENTA && Button.getText().equals("MAGENTA")) {
            Toast.makeText(Attention_Level2.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        }
        else if (color.getCurrentTextColor() == Color.GREEN && Button.getText().equals("GREEN")) {
            Toast.makeText(Attention_Level2.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        }
        else {
            Toast.makeText(Attention_Level2.this, "INCORRECT.", Toast.LENGTH_LONG).show();
            correct = false;
            if (correct = true) {
                color.setText("");
            }
            setUpColor();
            numOfQuestions++;
        }

        if(numOfQuestions==15)
        {
            endGame();
            ((TextView) findViewById(R.id.textView)).setText(" Final Score: " + getScore());
            ((TextView) findViewById(R.id.textView9)).setText("GameOver!!");


        }


    }
    public void endGame()
    {
        r2Button.setClickable(false);
        b2Button.setClickable(false);
        c2Button.setClickable(false);
        bk2Button.setClickable(false);
        m2Button.setClickable(false);
        g2Button.setClickable(false);
    }


    public void onClick(View v)
    {
        //TODO: Create FireBase DB Table for Memory Game
        AttentionGameData attentionGameData = new AttentionGameData();
        attentionGameData.setEmail(mAuth.getCurrentUser().getEmail());


        FirebaseDatabase attentionGameDB = FirebaseDatabase.getInstance().getInstance();
        DatabaseReference ref = attentionGameDB.getReference();
        //TODO: Needed to establish "timestamp" as key to avoid overrides and use the push( ) method
        DatabaseReference pushedKEYRef = ref.push();
        String t = attentionGameData.getTimeStamp();
        String timeStampID = pushedKEYRef.getKey();

        ref.child("attentiongame").child("user").setValue(mAuth.getCurrentUser().getEmail());
        ref.child("attentiongame").child("level02");
        ref.child("attentiongame").child("level02").child("timestamp").child("ID:"+timeStampID).setValue(attentionGameData.getTimeStamp());
        ref.child("attentiongame").child("level02").child("timestamp").child("ID"+timeStampID).child(attentionGameData.getTimeStamp())
                .child("score").setValue(score);



        Log.d("ACTION: ATTENTION INFO"," Access");

        //TODO: Upload data once user returns to level menu
        Intent intent = new Intent(this, AttentionLevels.class);
        startActivity(intent);
    }
    public int getScore()
    {
        return score;
    }

    public int getScoreInfo()
    {
        return score;
    } public String getScoreInfo(GameScore scores)
    {
        return "Level 1" + " Date: " + scores.getTime() +" "+ "Moves: " +  getScore();
    }



}
