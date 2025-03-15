package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FriendshipAdvicePage extends Activity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friendshipadvicepage);
        findViewById(R.id.gettingtoknow).setOnClickListener(v ->{
           Intent intent = new Intent(this, GettingtoKnow.class);
           startActivity(intent);
        });
        findViewById(R.id.socialnorms).setOnClickListener(v -> {
            Intent intent = new Intent(this, SocialNorms.class);
            startActivity(intent);
        });
        findViewById(R.id.thingstoask).setOnClickListener(v -> {
            Intent intent = new Intent(this, ThingstoAsk.class);
            startActivityForResult(intent, 0);
        });
        findViewById(R.id.faHome).setOnClickListener(v -> {
            //Toast.makeText(this, "Go back!!!", Toast.LENGTH_SHORT).show();
            finishActivity(0);
        });

    }

}


