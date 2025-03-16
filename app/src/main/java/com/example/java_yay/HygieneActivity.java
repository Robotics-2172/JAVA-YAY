package com.example.java_yay;

import android.app.Activity;
import android.os.Bundle;

public class HygieneActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.hygiene_layout);

        findViewById(R.id.hHomeButton).setOnClickListener(v -> finish());
    }
}
