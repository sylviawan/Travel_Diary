package com.example.sylviawan.traveldiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

// Adding an Entry

public class AddEntry extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    ListView listView;
    Button addEnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
    }

    public void onClickButton(View v){
        if(v.getId() == R.id.btnCreate)
        {
            EditText title = (EditText) findViewById(R.id.editTitle);
            EditText location = (EditText) findViewById(R.id.editLocation);
            EditText date = (EditText) findViewById(R.id.editDate);
            EditText desc = (EditText) findViewById(R.id.editDesc);

            String titlestr = title.getText().toString();
            String locationstr = location.getText().toString();
            String datestr = date.getText().toString();
            String descstr = desc.getText().toString();

            //Insert new entry in database
            Entry en = new Entry();
            en.setTitle(titlestr);
            en.setLocation(locationstr);
            en.setDate(datestr);
            en.setDesc(descstr);

            helper.insertUserEntries(en);
        }
    }
}
