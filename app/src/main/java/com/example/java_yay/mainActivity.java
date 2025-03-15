package com.example.java_yay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.datastore.core.DataStore;

public class mainActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mainactivity);
        findViewById(R.id.button).setOnClickListener(v->{
            EditText b = findViewById(R.id.editTextText);
            Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, test.class);

            startActivity(intent);
        });
    }
}
