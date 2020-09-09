package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;
import Validation.Validation;

public class RegistrationPage extends AppCompatActivity {

    EditText firstName, lastName, username, password;
    Button btnRegistration;
    SwitchMaterial switchBranch;
    CheckBox checkStatus;
    RadioGroup radioGroupGender;
    RadioButton selectRadioButtonGender;
    Spinner city;
    Validation val = new Validation();
    TextInputLayout passwordLayout , usernameLayout, firstNameLayout , lastNameLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        switchBranch = findViewById(R.id.switchBranch);
        checkStatus = findViewById(R.id.checkStatus);
        city = findViewById(R.id.spinnerCity);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        passwordLayout = findViewById(R.id.filledPassword);
        usernameLayout = findViewById(R.id.filledUsername);
        firstNameLayout = findViewById(R.id.filledFirstName);
        lastNameLayout = findViewById(R.id.filledLastName);

        btnRegistration = findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valFirstName = firstName.getText().toString();
                String valLastName = lastName.getText().toString();
                String valUsername = username.getText().toString();
                String valPassword = password.getText().toString();
                Boolean branch = switchBranch.isChecked();
                int rBtnId = radioGroupGender.getCheckedRadioButtonId();
                selectRadioButtonGender = findViewById(rBtnId);
                String valCity = city.getSelectedItem().toString();
                Boolean status = checkStatus.isChecked();

                if(!val.empty(valFirstName) && !val.empty(valLastName) && !val.empty(valUsername) && !val.empty(valPassword) && Patterns.EMAIL_ADDRESS.matcher(valUsername).matches() && password.length()>=8){
                    Intent i = new Intent(RegistrationPage.this,DisplayRegistrationData.class);
//                    Toast.makeText(RegistrationPage.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                    i.putExtra("firstName",valFirstName);
                    i.putExtra("lastName",valLastName);
                    i.putExtra("username",valUsername);
                    i.putExtra("password",valPassword);
                    i.putExtra("gender",selectRadioButtonGender.getText().toString());
                    i.putExtra("branch",branch);
                    i.putExtra("city",valCity);
                    i.putExtra("status",status);
                    passwordLayout.setError(null);
                    usernameLayout.setError(null);
                    firstNameLayout.setError(null);
                    lastNameLayout.setError(null);

                    startActivity(i);
                    Toast.makeText(RegistrationPage.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                }else{
                    if(val.empty(valFirstName)){
                        firstNameLayout.setError("Enter your first name");
                    }
                    if(val.empty(valLastName)){
                        lastNameLayout.setError("Enter your last name");
                    }
                    if(val.empty(valUsername) || Patterns.EMAIL_ADDRESS.matcher(valUsername).matches()){
                        usernameLayout.setError("Enter your valid email id");
                    }
                    if(val.empty(valPassword)){
                        passwordLayout.setError("Enter password");
                    }else{
                        passwordLayout.setError("Password should be more than 8 char long");
                    }
                }
            }
        });

    }
}