package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivityEngField extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eng_field);

        RadioButton civil = findViewById(R.id.radioButton1);

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent civilUni = new Intent(MainActivityEngField.this,MainActivityEngUni.class);
                startActivity(civilUni);
            }
        });

        ImageView home = findViewById(R.id.toHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivityEngField.this,MainActivityHome.class);
                startActivity(home);
                finish();
            }
        });
    }
}
