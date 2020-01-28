package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivityHome extends AppCompatActivity {

    public static final String GOOGLE_ACCOUNT = "google_account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        Button logOut = findViewById(R.id.button3);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(MainActivityHome.this,MainActivityMain.class);
                startActivity(main);
                finish();
            }
        });

        ImageView imageEng = findViewById(R.id.imageView);
        imageEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent engSub = new Intent(MainActivityHome.this,MainActivityEngField.class);
                startActivity(engSub);
            }
        });

        ImageView imageIT = findViewById(R.id.imageView8);
        imageIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itSub = new Intent(MainActivityHome.this,MainActivityItField.class);
                startActivity(itSub);
            }
        });



    }
}
