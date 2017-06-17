package com.example.eslamwael74.bookinglistapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivityAnimation extends AppCompatActivity {

    TextView hello;
    private static int SPLASH_TIME_OUT = 1800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animation);

        hello = (TextView) findViewById(R.id.hello);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);
        hello.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {

            //Showing splash screen with a timer.

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app First activity

                Intent i = new Intent(MainActivityAnimation.this, FirstActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


    }




