package com.example.java_yay;

import android.app.Activity;
import android.os.Bundle;

public class ThingsToAskActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.things_to_ask_layout);

        findViewById(R.id.questionsBackButton).setOnClickListener(v -> finish());
    }
}
