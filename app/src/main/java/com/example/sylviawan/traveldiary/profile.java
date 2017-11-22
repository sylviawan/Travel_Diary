package com.example.sylviawan.traveldiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {

    Button addentry, entries, settings, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        addentry = (Button) findViewById(R.id.btnAddEnt);
        entries = (Button) findViewById(R.id.btnToEntries);
        settings = (Button) findViewById(R.id.btnToSet);
        logout = (Button) findViewById(R.id.btnLogOut);

        //staff_id is final as it cannot and will not be edited or changed
        addentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, AddEntry.class);
                startActivity(i);
            }
        });

        entries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, Entries.class);
                startActivity(i);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
