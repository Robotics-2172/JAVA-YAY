package com.example.java_yay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FriendshipAdvicePage extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.test);
        findViewById(R.id.button3).setOnClickListener(v->{
            Toast.makeText(this, "Go back!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HygienePage.class);
            startActivityForResult(intent, 0);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        finish();
    }
}
