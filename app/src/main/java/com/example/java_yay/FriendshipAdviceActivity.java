package com.example.java_yay;

import static com.example.java_yay.UtilityFunctions.startActivityWithButton;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import org.w3c.dom.Text;

public class FriendshipAdviceActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friendship_advice_page);
        TextView tx = findViewById(R.id.textView);

        Typeface custom_font = ResourcesCompat.getFont(this, R.font.kay_pho_du);

        tx.setTypeface(custom_font);


        startActivityWithButton(this, R.id.gettingToKnowButton, GettingToKnowActivity.class);
        startActivityWithButton(this, R.id.socialNormsButton, SocialNormsActivity.class);
        findViewById(R.id.thingsToAskButton).setOnClickListener(v -> {
            Intent intent = new Intent(this, ThingsToAskActivity.class);
            startActivityForResult(intent, 0);
        });
        findViewById(R.id.faHomeButton).setOnClickListener(v -> finishActivity(0));
    }
}


