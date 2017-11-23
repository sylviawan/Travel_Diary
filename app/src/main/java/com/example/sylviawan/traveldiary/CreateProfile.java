package com.example.sylviawan.traveldiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateProfile extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button createaccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        createaccBtn = (Button) findViewById(R.id.btnCreate);

        //Button which creates a new account into the database
        createaccBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                EditText uname = (EditText) findViewById(R.id.cUser);
                EditText password = (EditText) findViewById(R.id.cPass);

                String unamestr = uname.getText().toString();
                String upassstr = password.getText().toString();

                //Insert new user in database
                User u = new User();
                u.setName(unamestr);
                u.setPassword(upassstr);

                helper.insertUser(u);

                Toast message = Toast.makeText(CreateProfile.this, "Profile created", Toast.LENGTH_SHORT);
                message.show();
            }

        });

    }

}
