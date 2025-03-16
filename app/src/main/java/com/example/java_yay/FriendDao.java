package com.example.java_yay;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FriendDao {
    @Query("SELECT * FROM Friend")
    List<Friend> getAll();

    @Query("SELECT * FROM Friend WHERE uid IN (:userIds)")
    List<Friend> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Friend WHERE name LIKE :name LIMIT 1")
    Friend findByName(String name);

    @Insert
    void insertAll(Friend... friends);

    @Delete
    void delete(Friend friend);
}
