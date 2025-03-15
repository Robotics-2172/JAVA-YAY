package com.example.java_yay;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Friend {
    @PrimaryKey
    public int uid;

    public String name;
    public String birthday;

}
