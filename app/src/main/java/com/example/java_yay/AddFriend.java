package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.CompletableFuture;

public class AddFriend extends Activity {
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.addfriend);
        ViewGroup vg = findViewById(R.id.linearlayout);

        findViewById(R.id.addfriendbutton).setOnClickListener(v -> {
            FriendDB db = ((CraigApplication) getApplication()).getFriendDB();
            Friend fr = new Friend();
            EditText b = findViewById(R.id.namefield);
            EditText c = findViewById(R.id.birthday);
            fr.name = b.getText().toString();
            fr.birthday = c.getText().toString();
            CompletableFuture.runAsync(() -> {
                db.friendDao().insertAll(fr);
            }).exceptionally(throwable -> null).thenRun(() -> {
                runOnUiThread(() -> {
                    Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show();
                });
                finish();
            });
        });
    }
}
