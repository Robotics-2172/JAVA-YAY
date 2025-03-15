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
        findViewById(R.id.faHome).setOnClickListener(v -> {
            //Toast.makeText(this, "Go back!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HygienePage.class);
            finish();
        });
    }
}


