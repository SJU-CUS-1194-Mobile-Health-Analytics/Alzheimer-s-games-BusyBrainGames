package com.example.sjack158.alzheimer_s_games_phase01_mockups.SpeedGame;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by CelesteG on 4/14/17.
 */

public class Game {


    private int[] scores = new int[100];
    private int size=9;

    public Button[] buttons = new Button[size];
    public TextView message;

    private int[] positions = new int[size];

    int moves;
    private boolean gameOver = false;
    private int buttonClickedIndex = 0;
    private int emptyLocationIndex = 0;



    public Game( Button[] buttons, TextView message) {
        this.buttons = buttons;
        this.message = message;


        for (int i = 0; i < buttons.length; i++) {
            positions[i] = i + 1;
        }
    }



    public void startNewGame() {
        gameOver = false;
        moves = 0;
        shuffleAllTiles();
        for (int i = 0; i < size; i++)
            buttons[i].setClickable(true);

        message.setText(" ");
    }

    private void shuffleAllTiles() {

        createListOfRandomTilePositions();
        for (int i = 0; i < size; i++) {

            buttons[i].setVisibility(View.VISIBLE);
            buttons[i].setText(String.format("%d", positions[i]));
            if (positions[i] == size)
                buttons[i].setVisibility(View.INVISIBLE);
        }
    }


    public void tryToMoveTile(View tile) {

        for (int i = 0; i < size; i++) {
            if (tile.getId() == buttons[i].getId()) {
                buttonClickedIndex = i;
                break;

            }

        }


        checkIfTileCanMove();
        moves++;


        if (emptyLocationIndex != -1) {
            swapTwoTiles();

        }
        checkForWin();


    }


    private void checkForWin() {

        boolean win = true;


        for (int i = 0; i < size; i++) {

            if (positions[i] != i + 1) {
                win = false;
                break;
            }
        }


        if (win) {
            gameOver = true;
            gameOver();

        }
    }


    private void gameOver() {

        for (int i = 0; i < size; i++)
            buttons[i].setClickable(false);


        message.setText("Replay Game or play next level!");
//
//        for(int i=0; i <size;i++)
//        {
//            scores[i].add(getMoves());
//        }

    }


    private int checkIfTileCanMove() {

        int[] locationsToCheck = new int[4];
        locationsToCheck[0] = buttonClickedIndex - 3;
        locationsToCheck[1] = buttonClickedIndex + 3;
        locationsToCheck[2] = buttonClickedIndex - 1;
        locationsToCheck[3] = buttonClickedIndex + 1;

        if (buttonClickedIndex == 2 || buttonClickedIndex == 5) {

            locationsToCheck[3] = -1;
        }

        for (int i = 0; i < 4; i++) {

            if (locationsToCheck[i] >= 0 && locationsToCheck[i] < size) {
                if (buttons[locationsToCheck[i]].isShown() == false) {
                    emptyLocationIndex = locationsToCheck[i];
                    return locationsToCheck[i];
                }
            }
        }
        emptyLocationIndex = -1;
        return -1;
    }

    private void swapTwoTiles() {

        buttons[buttonClickedIndex].setVisibility(View.INVISIBLE);
        buttons[emptyLocationIndex].setText(buttons[buttonClickedIndex].getText());
        buttons[emptyLocationIndex].setVisibility(View.VISIBLE);
        int temp = positions[emptyLocationIndex];
        positions[emptyLocationIndex] = positions[buttonClickedIndex];
        positions[buttonClickedIndex] = temp;
    }


    private void createListOfRandomTilePositions() {
        for (int i = size - 1; i >= 1; --i) {

            int j = (int) (Math.random() * size);
            int temp = positions[j];
            positions[j] = positions[i];
            positions[i] = temp;
        }
    }

    public int getMoves() {
        return moves;
    }



}
