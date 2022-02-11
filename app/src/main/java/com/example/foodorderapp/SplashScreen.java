package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this,LogandRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        },2500);


//
//        Thread thread = new Thread()
//        {
//            public void run()
//            {
//                try {
//                    sleep(2000);
//                }catch (Exception e)
//                {
//                    e.printStackTrace();
//                }finally {
//                    Intent intent = new Intent(SplashScreen.this,LogandRegisterActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };thread.start();

    }
}