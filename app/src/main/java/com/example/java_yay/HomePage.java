package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.CompletableFuture;


public class HomePage extends Activity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mainactivity);
        findViewById(R.id.friendshipadvice).setOnClickListener(v->{
            Intent intent = new Intent(this, FriendshipAdvicePage.class);
            startActivity(intent);
        });
        findViewById(R.id.friendslist).setOnClickListener(v-> {
            Intent intent = new Intent(this, FriendList.class);
            startActivity(intent);
        });
        findViewById(R.id.hygiene).setOnClickListener(v->{
            Intent intent = new Intent(this, HygienePage.class);
            startActivity(intent);
        });
    }
}
