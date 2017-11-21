package com.example.sylviawan.traveldiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.sylviawan.traveldiary.DatabaseHelper;

public class Login extends AppCompatActivity {

    Button btnlogin, btnToCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(R.id.btnlogin);
    }
}
