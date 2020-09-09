package com.example.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    TextView txtWelcomeMessage;

    //    ****************Tutorial06***********************
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    //    ****************Tutorial06***********************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
//    ****************Tutorial06***********************

        preferences = getSharedPreferences("session", MODE_PRIVATE);
        txtWelcomeMessage.setText("Welcome, "+preferences.getString("username",""));
        editor = preferences.edit();
//    ****************Tutorial06***********************


    }

//    ****************Tutorial06***********************

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.abt_menu:
                Toast.makeText(WelcomeActivity.this,"clicked on about us ..",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout_menu:
                editor.remove("username");
                editor.commit();
                Toast.makeText(WelcomeActivity.this,"Login-OUT",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//    ****************Tutorial06***********************

}