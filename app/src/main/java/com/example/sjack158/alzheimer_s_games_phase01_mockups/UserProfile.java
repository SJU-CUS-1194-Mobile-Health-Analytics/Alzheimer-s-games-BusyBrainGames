package com.example.sjack158.alzheimer_s_games_phase01_mockups;
import java.util.ArrayList;
/**
 * Created by CelesteG on 4/29/17.
 */

public class UserProfile {

    private String firstName;
    private String lastName;
    private ArrayList<GameScore> memoryScores;
    private ArrayList<GameScore> attentionScores;
    private ArrayList<GameScore> speedScores;


    public UserProfile(){
        this.firstName=" ";
        this.lastName= " ";
        this.memoryScores=new ArrayList<GameScore>();
        this.attentionScores=new ArrayList<GameScore>();
        this.speedScores=new ArrayList<GameScore>();
    }

    public UserProfile(String firstName, String lastName, ArrayList<GameScore> memoryScores, ArrayList<GameScore> attentionScores, ArrayList<GameScore>speedScores )
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.memoryScores=memoryScores;
        this.attentionScores=attentionScores;
        this.speedScores=speedScores;

    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }


    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public String getLastName()
    {
        return lastName;
    }

    public void setMemoryScores(ArrayList<GameScore> memoryScores)
    {
        this.memoryScores=memoryScores;
    }

    public ArrayList<GameScore> getMemoryScores()
    {
        return memoryScores;
    }

    public void setAttentionScores(ArrayList<GameScore> attentionScores)
    {
        this.attentionScores=attentionScores;
    }

    public ArrayList<GameScore> getAttentionScores()
    {
        return attentionScores;
    }

    public void setSpeedScores(ArrayList<GameScore> speedScores)
    {
        this.speedScores=speedScores;
    }

    public ArrayList<GameScore> getSpeedScores()
    {
        return speedScores;
    }
}
