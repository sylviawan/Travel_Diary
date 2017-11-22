package com.example.sylviawan.traveldiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateProfile extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    public void onCreateAccClick(View v)
    {
        if(v.getId() == R.id.btnCreate)
        {
            EditText uname = (EditText) findViewById(R.id.cUser);
            EditText upass = (EditText) findViewById(R.id.cPass);

            String unamestr = uname.getText().toString();
            String upassstr = upass.getText().toString();
        }
    }
}
