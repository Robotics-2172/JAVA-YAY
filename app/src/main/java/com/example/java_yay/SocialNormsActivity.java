package com.example.java_yay;

import android.app.Activity;
import android.os.Bundle;

public class SocialNormsActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.socialnorms);

        findViewById(R.id.backnorms).setOnClickListener(v -> finish());
    }
}
