package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    TextView newAccount;

//    ****************Tutorial06***********************
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    //    ****************Tutorial06***********************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);

//    ****************Tutorial06***********************

        preferences = getSharedPreferences("session",MODE_PRIVATE);
        editor = preferences.edit();
        String pref_username = preferences.getString("username","");
        if (pref_username != null && !pref_username.equals("")) {
            Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
            startActivity(intent);
            finish();
        }
//    ****************Tutorial06***********************


        newAccount = findViewById(R.id.txtNewRegistration);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegistrationPage.class);
                startActivity(i);
            }
        });

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valUsername = username.getText().toString();
                String valPassword = password.getText().toString();

                if(!Patterns.EMAIL_ADDRESS.matcher(valUsername).matches() && valPassword.length()>=8){
                    Toast.makeText(MainActivity.this,"Username or Password is incorrect",Toast.LENGTH_SHORT).show();
                    return;
                }

                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("Username",valUsername);

                //    ****************Tutorial06***********************

                    editor.putString("username",valUsername.trim());
                    editor.commit();
                //    ****************Tutorial06***********************

                startActivity(intent);
                    finish();

                    Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();

//                    Toast.makeText(MainActivity.this,"Username or Password is incorrect",Toast.LENGTH_SHORT).show();


            }
        });
    }

}