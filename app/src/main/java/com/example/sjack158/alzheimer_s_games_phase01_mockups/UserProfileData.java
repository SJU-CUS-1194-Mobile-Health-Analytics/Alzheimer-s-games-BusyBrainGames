package com.example.sjack158.alzheimer_s_games_phase01_mockups;

/**
 * Created by sjack158 05/06/2107
 */

//TODO: Attributes' Class for the "users" database table for FireBase
public class UserProfileData
{
    public String email;
    public String uid;
    public String fname;
    public String lname;
    public String fullName;

    public UserProfileData()
    {

    }
    public UserProfileData(String fname, String lname) {
        this.email = email;
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
    }

    public String getFullName(){return fullName;}
    public void setFullName(String fullName){this.fullName=fullName;}
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}



