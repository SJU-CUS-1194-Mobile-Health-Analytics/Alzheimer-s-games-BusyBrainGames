package com.example.sjack158.alzheimer_s_games_phase01_mockups;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;
import android.widget.Button;
import android.widget.Toast;

public class Attention_Level3 extends  AppCompatActivity {
    Button r3Button;
    Button b3Button;
    Button c3Button;
    Button bk3Button;
    Button m3Button;
    Button g3Button;
    Button gy3Button;
    Button y3Button;
    Button back;
    Date date= new Date();
    String datetime=date.toString();
    GameScore Attentionscore;

    TextView color;
    TextView gameScore;

    Boolean correct = false;
    int score;
    int numOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention_level3);
        Attentionscore = new GameScore(datetime, score);

        gameScore = (TextView) findViewById(R.id.textView7);

        color = (TextView) findViewById(R.id.textView);
        score = 0;
        setUpColor();
        back = (Button) findViewById(R.id.returnbutt);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Attention_Level3.this, AttentionLevels.class);
                startActivity(intent);
            }
        });
        r3Button = (Button) findViewById(R.id.r3Button);
        r3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(r3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }
        });

        b3Button = (Button) findViewById(R.id.b3Button);
        b3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(b3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });

        c3Button = (Button) findViewById(R.id.c3Button);
        c3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(c3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });

        bk3Button = (Button) findViewById(R.id.bk3Button);
        bk3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(bk3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });

        m3Button = (Button) findViewById(R.id.m3Button);
        m3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(m3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });

        g3Button = (Button) findViewById(R.id.g3Button);
        g3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(g3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });
        gy3Button = (Button) findViewById(R.id.gy3Button);
        gy3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(gy3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });
        y3Button = (Button) findViewById(R.id.y3Button);
        y3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMatching(y3Button);
                ((TextView) findViewById(R.id.textView7)).setText("Score:" + getScore());
            }

        });
    }

    public void setUpColor() {
        int[] colors = new int[]
                {
                        Color.RED, Color.BLUE, Color.CYAN, Color.BLACK, Color.MAGENTA, Color.GREEN, Color.GRAY, Color.YELLOW
                };

        String[] texts = new String[]
                {
                        "RED", "BLUE", "CYAN", "BLACK", "MAGENTA", "GREEN", "GRAY", "YELLOW"
                };

        String text = texts[randString(0, texts.length)];

        int c = colors[randInt(0, colors.length)];

        color.setText("" + text);
        for (int j = 0; j < colors.length; j++) {
            color.setTextColor(c);
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)) + min;
        return randomNum;
    }

    public static int randString(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)) + min;
        return randomNum;
    }

    public void isMatching(Button Button) {
        if (color.getCurrentTextColor() == Color.RED && Button.getText().equals("RED")) {
            correct = true;
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.BLUE && Button.getText().equals("BLUE")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;

        } else if (color.getCurrentTextColor() == Color.CYAN && Button.getText().equals("CYAN")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.BLACK && Button.getText().equals("BLACK")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.MAGENTA && Button.getText().equals("MAGENTA")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.GREEN && Button.getText().equals("GREEN")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.GRAY && Button.getText().equals("GRAY")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else if (color.getCurrentTextColor() == Color.YELLOW && Button.getText().equals("YELLOW")) {
            Toast.makeText(Attention_Level3.this, "CORRECT!", Toast.LENGTH_LONG).show();
            correct = true;
            if (correct = true) {
                color.setText("");
                score++;
            }
            setUpColor();
            numOfQuestions++;
        } else {
            Toast.makeText(Attention_Level3.this, "INCORRECT.", Toast.LENGTH_LONG).show();
            correct = false;
            if (correct = true) {
                color.setText("");
            }
            setUpColor();
            numOfQuestions++;
        }
        if (numOfQuestions == 20) {
            endGame();
            ((TextView) findViewById(R.id.textView)).setText("Final Score: " + getScore());
            ((TextView) findViewById(R.id.textView10)).setText("GameOver!!");


        }

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, AttentionLevels.class);
        startActivity(intent);
    }


    public int getScore() {
        return score;
    }

    public void endGame() {
        r3Button.setClickable(false);
        b3Button.setClickable(false);
        c3Button.setClickable(false);
        bk3Button.setClickable(false);
        m3Button.setClickable(false);
        g3Button.setClickable(false);
        gy3Button.setClickable(false);
        y3Button.setClickable(false);

    }public String getScoreInfo(GameScore scores)
    {
        return "Level 1" + " Date: " + scores.getTime() +" "+ "Moves: " +  getScore();
    }




}

