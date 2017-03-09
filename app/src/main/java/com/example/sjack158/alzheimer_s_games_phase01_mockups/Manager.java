package com.example.sjack158.alzheimer_s_games_phase01_mockups;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;

/**
 * Created by tian9 on 3/8/2017.
 */

public class Manager
{
    public CognitoCachingCredentialsProvider getcredentials(Context context)
    {
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider
                (context,
                "us-west-2:4acb4f4a-ede2-496f-ab14-962cda91b6e6", // Identity Pool ID
                Regions.US_WEST_2 // Region
        );
        return credentialsProvider;
    }

}
