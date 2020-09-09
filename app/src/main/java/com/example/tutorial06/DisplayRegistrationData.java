package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayRegistrationData extends AppCompatActivity {
    TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_registration_data);

        data = findViewById(R.id.DisplayTextView);

        String firstName,lastName,username,password,gender,city,prof_status = "Inactive";
        boolean status;
        Intent intent = getIntent();
        firstName = intent.getStringExtra("firstName");
        lastName = intent.getStringExtra("lastName");
        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");
        gender = intent.getStringExtra("gender");
        city = intent.getStringExtra("city");
        status = intent.getBooleanExtra("status",false);
        if (status){
            prof_status = "Active";
        }
        data.append("\n\nFirst Name : " + firstName+"\n"+"Last Name : " + lastName+"\n"+"Username : " + username+"\n"+"Password : " + password+"\n"+"Gender : " + gender+"\n"+"City : " +city+"\n"+"Status : "+prof_status);

    }
}