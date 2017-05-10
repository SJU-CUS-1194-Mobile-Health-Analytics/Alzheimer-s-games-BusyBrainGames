package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * Created by sjack158 on 5/8/2017.
 *
 */


public class UserProfileGameResults extends Activity {

    private FirebaseAuth mAuth;

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_scores_graph);

        mAuth = FirebaseAuth.getInstance();


    }

        /*TODO: Create an arraylist of each point (x,y)
                (1) MemoryGame TimeStamp
                (2) MemoryGame Scores

        */
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
//                new DataPoint(0, 1),
//                new DataPoint(1,2),
//                new DataPoint(2, 3),
//                new DataPoint(3, 3),
//                new DataPoint(4, 4)
//
//
//        });
//        graph.addSeries(series);


    public void drawMemoryLineGraph() {
        final ArrayList<Integer> memoryscores = new ArrayList<Integer>();
        final ArrayList<Integer> memoryTimestamps = new ArrayList<Integer>();

        final MemoryGameData memoryGameData = new MemoryGameData();
        memoryGameData.setEmail(mAuth.getCurrentUser().getEmail());


        FirebaseDatabase memoryGameDB = FirebaseDatabase.getInstance().getInstance();
        DatabaseReference ref = memoryGameDB.getReference();
        //TODO: Needed to establish "timestamp" as key to avoid overrides and use the push( ) method
        DatabaseReference pushedKEYRef = ref.push();
        String t = memoryGameData.getTimeStamp();
        String timeStampID = pushedKEYRef.getKey();


        ref.child("memorygame").child("level01").child("timestamp").child("ID" + timeStampID).child(memoryGameData.getTimeStamp())
                .child("score").setValue(memoryGameData.getScore());

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                GraphView memoryscoresgraph = (GraphView) findViewById(R.id.graph);

                for (DataSnapshot data : children) {

                    MemoryGameData memoryGameData1 = data.getValue(MemoryGameData.class);
                    memoryscores.add(memoryGameData1.score);

                    String s = memoryGameData.timeStamp.format(memoryGameData.timeStamp);
                    int output = Integer.valueOf(s);
                    memoryTimestamps.add(output);


                    series = new LineGraphSeries<>();

                    switch (memoryscores.size()) {

                        case 1: {
                            series = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(memoryTimestamps.get(0), memoryscores.get(0))
                            });
                            break;

                        }


                        case 2: {
                            series = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(memoryTimestamps.get(0), memoryscores.get(0)),
                                    new DataPoint(memoryTimestamps.get(1), memoryscores.get(1))

                            });
                            break;

                        }

                        case 3: {
                            series = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(memoryTimestamps.get(0), memoryscores.get(0)),
                                    new DataPoint(memoryTimestamps.get(1), memoryscores.get(1)),
                                    new DataPoint(memoryTimestamps.get(2), memoryscores.get(2))

                            });
                            break;

                        }

                        case 4: {
                            series = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(memoryTimestamps.get(0), memoryscores.get(0)),
                                    new DataPoint(memoryTimestamps.get(1), memoryscores.get(1)),
                                    new DataPoint(memoryTimestamps.get(2), memoryscores.get(2)),
                                    new DataPoint(memoryTimestamps.get(3), memoryscores.get(3)),

                            });
                            break;

                        }

                        case 5: {
                            series = new LineGraphSeries<>(new DataPoint[]{
                                    new DataPoint(memoryTimestamps.get(0), memoryscores.get(0)),
                                    new DataPoint(memoryTimestamps.get(1), memoryscores.get(1)),
                                    new DataPoint(memoryTimestamps.get(2), memoryscores.get(2)),
                                    new DataPoint(memoryTimestamps.get(3), memoryscores.get(3)),
                                    new DataPoint(memoryTimestamps.get(4), memoryscores.get(4))

                            });
                            break;

                        }

                    }


                    memoryscoresgraph.addSeries(series);
                    series.setDrawDataPoints(true);
                    series.setDataPointsRadius(20);

                    memoryscoresgraph.getViewport().setXAxisBoundsManual(true);
                    memoryscoresgraph.getViewport().setMinX(0);
                    memoryscoresgraph.getViewport().setMaxX(20);

                    memoryscoresgraph.getViewport().setYAxisBoundsManual(true);
                    memoryscoresgraph.getViewport().setMinY(0);
                    memoryscoresgraph.getViewport().setMaxY(100);

                    memoryscoresgraph.getViewport().setScalable(true);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}