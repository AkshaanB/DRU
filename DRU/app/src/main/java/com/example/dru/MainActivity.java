package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler transfer = new Handler();
        transfer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent first = new Intent(MainActivity.this,MainActivityMain.class);
                MainActivity.this.startActivity(first);
                MainActivity.this.finish();
            }
        },3000);
    }
}
