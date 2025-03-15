package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

public class GettingtoKnow extends Activity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.gettingtoknow);

        findViewById(R.id.gettingtoknowback).setOnClickListener(v -> {
            finish();
        });
    }
}
