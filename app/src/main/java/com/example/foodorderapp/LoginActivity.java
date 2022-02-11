package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button signin;
    TextView facebook,google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        signin = findViewById(R.id.registerbtn);
        facebook = findViewById(R.id.facebook);
        google = findViewById(R.id.google);
        
        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("Email");
        String userPass = intent.getStringExtra("Password");
        email.setText(userEmail);
        password.setText(userPass);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailData = email.getText().toString();
                String pass = password.getText().toString();
                if((emailData.isEmpty() && pass.isEmpty()) || emailData.isEmpty() || pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Fill all details", Toast.LENGTH_SHORT).show();
                }else {
                    StringBuilder builder = new StringBuilder();
                    builder.append("Login Details");
                    builder.append("\n Email: " + emailData);
                    builder.append("\n Password: " + pass);
                    builder.append("\n Successfully Login!");
                    Toast.makeText(LoginActivity.this, builder, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void social(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(intent,"Login using");
        startActivity(shareIntent);

    }


}