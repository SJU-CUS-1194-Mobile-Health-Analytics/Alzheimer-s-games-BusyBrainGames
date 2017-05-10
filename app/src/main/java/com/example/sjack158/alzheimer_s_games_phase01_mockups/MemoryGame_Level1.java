package com.example.sjack158.alzheimer_s_games_phase01_mockups;


import android.content.Context;
        import android.content.Intent;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TableLayout;
        import android.widget.TableRow;
        import android.widget.TextView;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
        import java.util.Random;
        import java.util.Timer;
        import java.util.TimerTask;



/*
   TODO:Import Information for Firebase Database
*/

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by CelesteG on 4/19/17.
 *
 */

public class MemoryGame_Level1 extends AppCompatActivity {


    private static int NumOfRows = -1;
    private static int NumOfColumns = -1;
    private Context context;
    private View view;
    private Drawable backOfCard;
    private int [] [] cards;
    private List<Drawable> cardImages;
    private MemoryGameCard card2;
    private MemoryGameCard card1;
    private ButtonListener buttonListener;
    private static Object lock = new Object();
    private int x=4;
    private int y=4;
    int turns;

    int moves;
    Date date= new Date();
    String datetime=date.toString();
    GameScore score;


    private TableLayout menuLayout;
    private UpdateCardsHandler handler;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game_level1);

        mAuth = FirebaseAuth.getInstance();

        handler = new UpdateCardsHandler();
        createCards();
        backOfCard = getResources().getDrawable(R.drawable.redbrain);
        menuLayout = (TableLayout) findViewById(R.id.MenuLayout);
        context = menuLayout.getContext();
        buttonListener = new ButtonListener();
        newGame(x,y);




    }



    private void newGame(int rows, int columns) {
        NumOfRows = rows;
        NumOfColumns = columns;
        cards = new int [NumOfColumns] [NumOfRows];
        menuLayout.removeView(findViewById(R.id.TableRow02));
        menuLayout.removeView(findViewById(R.id.TableRow3));

        TableRow row = ((TableRow)findViewById(R.id.TableRow04));
        row.removeAllViews();
        context = menuLayout.getContext();
        menuLayout= new TableLayout(context);
        row.addView(menuLayout);

        for (int y = 0; y < NumOfRows; y++)
        {
            menuLayout.addView(createNewRow(y));
        }
        card1=null;
        addCards();
        turns=0;
        ((TextView)findViewById(R.id.tv1)).setText("Moves: "+turns);
        //createCards();

    }

    private void createCards() {
        cardImages = new ArrayList<Drawable>();
        cardImages.add(getResources().getDrawable(R.drawable.card1));
        cardImages.add(getResources().getDrawable(R.drawable.card2));
        cardImages.add(getResources().getDrawable(R.drawable.card3));
        cardImages.add(getResources().getDrawable(R.drawable.card4));
        cardImages.add(getResources().getDrawable(R.drawable.card5));
        cardImages.add(getResources().getDrawable(R.drawable.card6));
        cardImages.add(getResources().getDrawable(R.drawable.card7));
        cardImages.add(getResources().getDrawable(R.drawable.card8));
        cardImages.add(getResources().getDrawable(R.drawable.card9));
        cardImages.add(getResources().getDrawable(R.drawable.card10));
        cardImages.add(getResources().getDrawable(R.drawable.card11));
        cardImages.add(getResources().getDrawable(R.drawable.card12));
        cardImages.add(getResources().getDrawable(R.drawable.card13));
        cardImages.add(getResources().getDrawable(R.drawable.card14));
        cardImages.add(getResources().getDrawable(R.drawable.card15));
        cardImages.add(getResources().getDrawable(R.drawable.card16));
        cardImages.add(getResources().getDrawable(R.drawable.card17));
        cardImages.add(getResources().getDrawable(R.drawable.card18));
        cardImages.add(getResources().getDrawable(R.drawable.card19));
        cardImages.add(getResources().getDrawable(R.drawable.card20));
        cardImages.add(getResources().getDrawable(R.drawable.card21));

    }

    private void addCards(){
        try{
            int gameSize = NumOfRows*NumOfColumns;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<gameSize;i++){
                list.add(new Integer(i));
            }
            Random r = new Random();
            for(int i=gameSize-1;i>=0;i--){
                int j=0;
                if(i>0){
                    j = r.nextInt(i);
                }
                j=list.remove(j).intValue();
                cards[i%NumOfColumns][i/NumOfColumns]=j%(gameSize/2);
            }
        }
        catch (Exception exception) {
            Log.e("addCards()", exception+"");
        }
    }

    private TableRow createNewRow(int y){
        TableRow row = new TableRow(context);
        row.setGravity(Gravity.CENTER_HORIZONTAL);

        for (int x = 0; x < NumOfColumns; x++) {
            row.addView(createImageButton(x,y));
        }
        return row;
    }


    private View createImageButton(int x, int y){
        Button button = new Button(context);
        button.setBackgroundDrawable(backOfCard);

        button.setId(100*x+y);
        button.setOnClickListener(buttonListener);
        return button;
    }
    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            synchronized (lock) {
                if(card1!=null && card2 != null){
                    return;
                }
                int id = v.getId();
                int x = id/100;
                int y = id%100;
                flip((Button)v,x,y);
            }

        }

        private void flip(Button button,int a, int b) {
            button.setBackgroundDrawable(cardImages.get(cards[a][b]));
            if(card1==null){
                card1 = new MemoryGameCard(button,a,b);

            }
            else{

                if(card1.x == a && card1.y == b){
                    return;
                }

                card2 = new MemoryGameCard(button,a,b);

                turns++;
                ((TextView)findViewById(R.id.tv1)).setText("Moves: "+turns);



                TimerTask task = new TimerTask() {

                    @Override
                    public void run() {
                        try{
                            synchronized (lock) {
                                handler.sendEmptyMessage(0);
                            }
                        }
                        catch (Exception excep) {
                            Log.e("Exception", excep.getMessage());
                        }
                    }
                };

                Timer timer = new Timer(false);
                timer.schedule(task, 1000);


            }


        }

    }

    class UpdateCardsHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            synchronized (lock) {
                MatchCards();
            }
        }
        public void MatchCards(){
            if(cards[card2.x][card2.y] == cards[card1.x][card1.y]){
                card1.button.setVisibility(View.INVISIBLE);
                card2.button.setVisibility(View.INVISIBLE);
            }
            else {
                card2.button.setBackgroundDrawable(backOfCard);
                card1.button.setBackgroundDrawable(backOfCard);
            }

            card1=null;
            card2=null;
        }
    }
    public void sendMessage( View v)
    {

        //TODO: Create FireBase DB Table for Memory Game
        MemoryGameData memoryGameData = new MemoryGameData();
        memoryGameData.setEmail(mAuth.getCurrentUser().getEmail());


        FirebaseDatabase memoryGameDB = FirebaseDatabase.getInstance().getInstance();
        DatabaseReference ref = memoryGameDB.getReference();
        //TODO: Needed to establish "timestamp" as key to avoid overrides and use the push( ) method
        DatabaseReference pushedKEYRef = ref.push();
        String t = memoryGameData.getTimeStamp();
        String timeStampID = pushedKEYRef.getKey();

        ref.child("memorygame").child("user").setValue(mAuth.getCurrentUser().getEmail());
        ref.child("memorygame").child("level01");
        ref.child("memorygame").child("level01").child("timestamp").child("ID:"+timeStampID).setValue(memoryGameData.getTimeStamp());
        ref.child("memorygame").child("level01").child("timestamp").child("ID"+timeStampID).child(memoryGameData.getTimeStamp())
                .child("score").setValue(turns);



        Log.d("ACTION: MEMORYGAME INFO"," Access");

        //TODO: Upload data once user returns to level menu
        Intent intent = new Intent(this, MemoryLevels.class);
        startActivity(intent);
    }

    public String getScoreInfo(GameScore scores)
    {
        return "Level 1" + " Date: " + scores.getTime() +" "+ "Moves: " +  scores.getScore();
    }









}
