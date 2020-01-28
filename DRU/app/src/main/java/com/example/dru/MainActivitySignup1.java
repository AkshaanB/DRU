package com.example.dru;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivitySignup1 extends AppCompatActivity {
    private GoogleSignInClient googleSignInClient;
    private static final String TAG = "AndroidClarified";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup1);

        SignInButton googleSignIn = findViewById(R.id.sign_in_button);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);
        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signINIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signINIntent,101);
            }
        });

        Button signUp = findViewById(R.id.button6);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createAccount = new Intent(MainActivitySignup1.this,MainActivitySigUp2.class);
                startActivity(createAccount);
                finish();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == Activity.RESULT_OK)
            try {
                if (requestCode == 101) {
                    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    onLoggedIn(account);
                }else {
                    Toast.makeText(this,"Signed in failed",Toast.LENGTH_SHORT).show();
                }
            }catch (ApiException e) {
                Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            }
    }
    private void onLoggedIn(GoogleSignInAccount googleSignInAccount) {
        Intent intent = new Intent(this, MainActivityHome.class);
        intent.putExtra(MainActivityHome.GOOGLE_ACCOUNT, googleSignInAccount);

        startActivity(intent);
        finish();
    }
    @Override
    public void onStart(){
        super.onStart();
        GoogleSignInAccount signedIn  = GoogleSignIn.getLastSignedInAccount(this);
        if (signedIn != null){
            Toast.makeText(this,"Signed In",Toast.LENGTH_SHORT).show();
            onLoggedIn(signedIn);
        }else {
            Log.d(TAG,"Still not logged in...");
        }
    }
}
