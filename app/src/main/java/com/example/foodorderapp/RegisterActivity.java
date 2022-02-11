package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    TextView uploadImage,facebook,google;
    EditText userName,phone,emailAdd,passwordReg;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        uploadImage = findViewById(R.id.uploadImage);
        userName = findViewById(R.id.userName);
        phone = findViewById(R.id.phoneNumber);
        emailAdd = findViewById(R.id.emailAdd);
        passwordReg = findViewById(R.id.passwordReg);
        signup = findViewById(R.id.register);
        facebook = findViewById(R.id.fbook);
        google = findViewById(R.id.googlelog);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = userName.getText().toString();
               String phoneno = phone.getText().toString();
               String emailadd = emailAdd.getText().toString();
               String password = passwordReg.getText().toString();
               if(name.isEmpty() && phoneno.isEmpty() && emailadd.isEmpty() && password.isEmpty())
               {
                   Toast.makeText(RegisterActivity.this, "Fill all details", Toast.LENGTH_SHORT).show();
               }else {
                   StringBuilder builder = new StringBuilder();
                   builder.append("SignUp Details");
                   builder.append("\n UserName: " + name);
                   builder.append("\n Phone: " + phoneno);
                   builder.append("\n Email: " + emailadd);
                   builder.append("\n password: " + password);
                   Toast.makeText(RegisterActivity.this, builder, Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                   intent.putExtra("Email", emailadd);
                   intent.putExtra("Password", password);
                   startActivity(intent);
               }
            }
        });
        action();

    }
    public void action()
    {
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Currently Unavailable", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void loginmethod(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(intent,"Login using");
        startActivity(shareIntent);

    }



}