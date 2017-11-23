package com.example.sylviawan.traveldiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    Button addentry, entries, settings, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        addentry = (Button) findViewById(R.id.btnToAddEntry);
        entries = (Button) findViewById(R.id.btnToEntries);
        settings = (Button) findViewById(R.id.btnToSet);
        logout = (Button) findViewById(R.id.btnLogOut);


        // Four main buttons for the user to choose
        // from: Add Entry, Entries, Settings and Logout

        addentry.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, AddEntry.class);
                startActivity(i);
            }
        });

        entries.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, Entries.class);
                startActivity(i);
            }
        });

        settings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, MainActivity.class);
                startActivity(i);
                Toast logout = Toast.makeText(Profile.this, "Logging out", Toast.LENGTH_SHORT);
                logout.show();
            }
        });
    }
}
