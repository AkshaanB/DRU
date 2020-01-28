package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityITUni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_it_uni);

        ImageView home = findViewById(R.id.toHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivityITUni.this,MainActivityHome.class);
                startActivity(home);
                finish();
            }
        });

        TextView iitSortware = findViewById(R.id.textView2);
        iitSortware.setMovementMethod(LinkMovementMethod.getInstance());

        TextView sliitSortware = findViewById(R.id.textView6);
        sliitSortware.setMovementMethod(LinkMovementMethod.getInstance());

        TextView icbtSortware = findViewById(R.id.textView9);
        icbtSortware.setMovementMethod(LinkMovementMethod.getInstance());

        TextView northshoreSortware = findViewById(R.id.textView10);
        northshoreSortware.setMovementMethod(LinkMovementMethod.getInstance());

        TextView nsbmSortware = findViewById(R.id.textView11);
        nsbmSortware.setMovementMethod(LinkMovementMethod.getInstance());

        TextView esoftSortware = findViewById(R.id.textView13);
        esoftSortware.setMovementMethod(LinkMovementMethod.getInstance());

        TextView apiitSortware = findViewById(R.id.textView14);
        apiitSortware.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
