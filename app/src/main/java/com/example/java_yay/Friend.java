package com.example.java_yay;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity
@TypeConverters(DateConverter.class)
public class Friend {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String name;
    public Date birthday;
    public String description;

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
