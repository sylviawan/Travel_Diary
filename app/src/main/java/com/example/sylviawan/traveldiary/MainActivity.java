package com.example.sylviawan.traveldiary;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ADD SPLASH_TIMEOUT to go to Log in Activity
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Login.class);
                MainActivity.this.startActivity(i);
                MainActivity.this.finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
