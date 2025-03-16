package com.example.java_yay;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

public class FriendshipAdviceActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friendship_advice_page);
        TextView tx = findViewById(R.id.textView);

        Typeface custom_font = ResourcesCompat.getFont(this, R.font.kay_pho_du);

        tx.setTypeface(custom_font);
    }
}


