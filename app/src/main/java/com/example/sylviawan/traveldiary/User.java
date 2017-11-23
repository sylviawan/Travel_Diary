package com.example.sylviawan.traveldiary;

/**
 * Class for users
 * Created by sylviawan
 */

public class User {

    String username, password;

    public void setName (String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return this.username;
    }
    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getPass()
    {
        return this.password;
    }
}
