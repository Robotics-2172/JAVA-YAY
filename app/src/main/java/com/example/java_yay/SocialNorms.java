package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

public class SocialNorms extends Activity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.socialnorms);
        findViewById(R.id.backnorms).setOnClickListener(v -> {
            finish();
        });
    }
}
