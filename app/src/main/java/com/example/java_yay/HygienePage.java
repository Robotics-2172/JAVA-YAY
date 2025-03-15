package com.example.java_yay;

import android.app.Activity;
import android.os.Bundle;

public class HygienePage extends Activity {

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
