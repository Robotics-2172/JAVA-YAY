package com.example.java_yay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.CompletableFuture;


public class HomePage extends Activity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mainactivity);

        FriendDB db = ((CraigApplication)getApplication()).getFriendDB();


        findViewById(R.id.button).setOnClickListener(v->{

            CompletableFuture.supplyAsync(()->{
                return db.friendDao().getAll();

            }).thenAccept(l->{
                for (Friend f: l) {
                    Log.i("Tag", f.name);
                }
            });

            Intent intent = new Intent(this, FriendshipAdvicePage.class);

            startActivity(intent);
        });
        findViewById(R.id.saveButton).setOnClickListener(v->{
            Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();
            Friend fr = new Friend();
            EditText b = findViewById(R.id.editTextText);
            fr.name = b.getText().toString();
            fr.birthday = "12/12/12";
            CompletableFuture.runAsync(()->{
                //runOnUiThread(()-> Toast.makeText(this, "Working 2", Toast.LENGTH_SHORT).show());
                db.friendDao().insertAll(fr);
                runOnUiThread(()-> Toast.makeText(this, "Working 2", Toast.LENGTH_SHORT).show());
            }).exceptionally(throwable -> {
                Log.e("Tag", Log.getStackTraceString(throwable));
                return null;
            }).thenRun(()->{
                runOnUiThread(()->{
                    Toast.makeText(this, "Added!" + fr.name, Toast.LENGTH_SHORT).show();
                });
            });

        });
        findViewById(R.id.clearButton).setOnClickListener(v-> {
            CompletableFuture.runAsync(() -> {
                for (Friend f : db.friendDao().getAll()) {
                db.friendDao().delete(f);
            };
        });
    });

    }
}
