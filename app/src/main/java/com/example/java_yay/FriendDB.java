package com.example.java_yay;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Friend.class}, version = 1)
public abstract class FriendDB extends RoomDatabase {
    public abstract FriendDao friendDao();
}
