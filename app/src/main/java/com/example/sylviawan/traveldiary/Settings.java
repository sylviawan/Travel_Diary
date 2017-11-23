package com.example.sylviawan.traveldiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        change = (Button) findViewById(R.id.changeDet);

        change.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                EditText uname = (EditText) findViewById(R.id.cUser);
                EditText password = (EditText) findViewById(R.id.cPass);

                String unamestr = uname.getText().toString();
                String upassstr = password.getText().toString();

                //update a user in database
                User u = new User();
                u.setName(unamestr);
                u.setPassword(upassstr);

                helper.updateUsers(u);
            }

        });

    }

}
