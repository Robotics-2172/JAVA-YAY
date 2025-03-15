package com.example.java_yay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class test extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.test);
        findViewById(R.id.button3).setOnClickListener(v->{
            Toast.makeText(test.this, "Go back!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(test.this, mainActivity.class);
            startActivity(intent);
        });
    }
}
