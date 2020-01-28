package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivityMain extends AppCompatActivity {
    private TextToSpeech speech;
    private Button signup;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        Button login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = findViewById(R.id.editText);
                password = findViewById(R.id.editText2);
                if (username.getText().toString().equals("owner")&& password.getText().toString().equals("123")){
                    Intent loginIn = new Intent(MainActivityMain.this,MainActivityHome.class);
                    Toast.makeText(getApplicationContext(),"Do not press back key!",Toast.LENGTH_SHORT).show();
                    startActivity(loginIn);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Username or Password is wrong", Toast.LENGTH_SHORT).show();
                    username.getText().clear();
                    password.getText().clear();
                }

            }
        });

        speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    int result = speech.setLanguage(Locale.UK);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Language not supported!");
                    }else {
                        signup = findViewById(R.id.button2);
                        signup.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent signup = new Intent(MainActivityMain.this,MainActivitySignup1.class);
                                startActivity(signup);
                                speak();
                            }
                        });
                    }
                }else {
                    Log.e("TTS","Initialization failed!");
                }
            }
        });
    }
    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onDestroy() {
        if (speech!=null){
            speech.stop();
            speech.shutdown();
        }
        super.onDestroy();
    }

    private void speak(){
        String name = username.getText().toString();
        speech.speak(name,TextToSpeech.QUEUE_FLUSH,null);
    }
}
