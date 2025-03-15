package com.example.java_yay;

import android.app.Application;

import androidx.room.Room;

public class CraigApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        friendDB = Room.databaseBuilder(this, FriendDB.class, "friend-database").build();
    }
    public FriendDB getFriendDB(){
        return friendDB;
    }
    private FriendDB friendDB;
}
