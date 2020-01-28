package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivityItField extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_it_field);

        RadioButton software = findViewById(R.id.radioButton1);

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent softwareUni = new Intent(MainActivityItField.this,MainActivityITUni.class);
                startActivity(softwareUni);
            }
        });

        ImageView home = findViewById(R.id.toHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivityItField.this,MainActivityHome.class);
                startActivity(home);
                finish();
            }
        });
    }
}
