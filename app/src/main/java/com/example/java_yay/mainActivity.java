package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class mainActivity extends Activity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.mainactivity);
        findViewById(R.id.button).setOnClickListener(v->{
            Toast.makeText(mainActivity.this, "Hello World", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.test);
        });
    }
}
