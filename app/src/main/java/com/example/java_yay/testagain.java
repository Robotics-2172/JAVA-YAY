package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class testagain extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.testagain);
        findViewById(R.id.button2).setOnClickListener(v ->{
            setResult(0);
            finish();
      });
    }
}
