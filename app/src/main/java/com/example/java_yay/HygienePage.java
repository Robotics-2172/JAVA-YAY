package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class HygienePage extends Activity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.hygiene);
        findViewById(R.id.hHome).setOnClickListener(v ->{
            finish();
      });
    }
}
