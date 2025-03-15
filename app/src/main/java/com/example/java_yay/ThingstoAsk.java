package com.example.java_yay;

import android.app.Activity;
import android.os.Bundle;

public class ThingstoAsk extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.thingstoask);
        findViewById(R.id.questionsback).setOnClickListener(v -> {
            finish();
        });
    }
}
