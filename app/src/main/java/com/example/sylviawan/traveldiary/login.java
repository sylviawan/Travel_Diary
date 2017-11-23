package com.example.sylviawan.traveldiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sylviawan.traveldiary.DatabaseHelper;

public class Login extends AppCompatActivity {

    //Creating an instance of the database
    DatabaseHelper helper = new DatabaseHelper(this);
    Button btnlogin, btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button)findViewById(R.id.btnlogin);

        final EditText u_name = (EditText) findViewById(R.id.loginUN);
        final String str = u_name.getText().toString();

        EditText u_pass = (EditText) findViewById(R.id.loginpw);
        final String pass = u_pass.getText().toString();

        // Log in Button
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = helper.searchPass(str,pass);
                Log.e("returned pass", password);

                /*Intent intent = new Intent(Login.this, Profile.class);
                startActivity(intent);
                */

                //Error checking if the inputs are correct
                if(password.equals(password))
                {
                    Intent i = new Intent(Login.this, Profile.class);
                    startActivity(i);
                }
                else
                {
                    Toast mess = Toast.makeText(Login.this, "Incorrect details", Toast.LENGTH_SHORT);
                    mess.show();
                }
            }
        });

        // Button to create a new profile
        btnCreate = (Button)findViewById(R.id.btnToCreate);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, CreateProfile.class);
                startActivity(i);

            }
        });
    }
}
