package com.example.java_yay;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Friend {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String name;
    public String birthday;

}
