package com.example.java_yay;

import static com.example.java_yay.UtilityFunctions.startActivityWithButton;

import android.app.Activity;
import android.os.Bundle;


public class HomePageActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.main_layout);

        startActivityWithButton(this, R.id.friendshipAdviceButton, FriendshipAdviceActivity.class);
        startActivityWithButton(this, R.id.friendsListButton, FriendListActivity.class);
        startActivityWithButton(this, R.id.hygieneButton, HygieneActivity.class);
    }
}
