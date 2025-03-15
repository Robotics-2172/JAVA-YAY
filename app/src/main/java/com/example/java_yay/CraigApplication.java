package com.example.java_yay;

import android.app.Application;

import androidx.room.Room;

public class CraigApplication extends Application {
    public static final String TAG = "CraigApp";
    public static final String FRIEND_DATABASE_NAME = "friend-database";

    private FriendDB friendDB;

    @Override
    public void onCreate() {
        super.onCreate();
        friendDB = Room.databaseBuilder(this, FriendDB.class, FRIEND_DATABASE_NAME).build();
    }

    /**
     * Returns the application level singleton of the friend database.
     * @return the application level singleton of the friend database
     */
    public FriendDB getFriendDB() {
        return friendDB;
    }
}
