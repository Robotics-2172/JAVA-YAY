package com.example.java_yay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;


public class mainActivity extends Activity {

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

            Intent intent = new Intent(this, test.class);

            startActivity(intent);
        });
        findViewById(R.id.saveButton).setOnClickListener(v->{
            Friend fr = new Friend();
            EditText b = findViewById(R.id.editTextText);
            fr.name = b.getText().toString();
            CompletableFuture.runAsync(()->{
                db.friendDao().insertAll(fr);
            }).thenRun(()->{
                runOnUiThread(()->{
                    Toast.makeText(this, "Added!" + fr.name, Toast.LENGTH_SHORT).show();
                });
            });

        });
    }
}
