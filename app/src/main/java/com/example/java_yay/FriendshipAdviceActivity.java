package com.example.java_yay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FriendshipAdviceActivity extends Activity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friendship_advice_layout);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_getting_to_know_someone) {
                Intent intent = new Intent(this, GettingToKnowActivity.class);
                startActivity(intent);
            }
            else if (item.getItemId() == R.id.nav_social_norms) {
                Intent intent = new Intent(this, SocialNormsActivity.class);
                startActivity(intent);
            }
            else if (item.getItemId() == R.id.nav_things_to_ask) {
                Intent intent = new Intent(this, ThingsToAskActivity.class);
                startActivity(intent);
            }
            else if (item.getItemId() == R.id.nav_home) {
                finish();
            }
            mDrawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            finish();
        }
    }
}


