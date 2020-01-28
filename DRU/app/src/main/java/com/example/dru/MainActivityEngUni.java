package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityEngUni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eng_uni);


        TextView sliitCivil = findViewById(R.id.textView10);
        sliitCivil.setMovementMethod(LinkMovementMethod.getInstance());

        TextView sltcCivil = findViewById(R.id.textView12);
        sltcCivil.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cinecCivil = findViewById(R.id.textView14);
        cinecCivil.setMovementMethod(LinkMovementMethod.getInstance());

        TextView northshoreCivil = findViewById(R.id.textView16);
        northshoreCivil.setMovementMethod(LinkMovementMethod.getInstance());

        TextView icbtCivil = findViewById(R.id.textView17);
        icbtCivil.setMovementMethod(LinkMovementMethod.getInstance());

        ImageView home = findViewById(R.id.toHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivityEngUni.this,MainActivityHome.class);
                startActivity(home);
                finish();
            }
        });
    }
}
