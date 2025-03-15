package com.example.java_yay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class mainActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mainactivity);
        findViewById(R.id.button).setOnClickListener(v->{
            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, test.class);
            startActivity(intent);
        });
    }
}
