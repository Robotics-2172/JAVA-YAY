package com.example.java_yay;

import android.app.Activity;
import android.os.Bundle;

public class GettingToKnowActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.getting_to_know_layout);

        findViewById(R.id.gettingToKnowBackButton).setOnClickListener(v -> finish());
    }
}
