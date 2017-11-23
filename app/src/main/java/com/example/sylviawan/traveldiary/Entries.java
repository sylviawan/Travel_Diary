package com.example.sylviawan.traveldiary;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Entries extends ListActivity {

    //ListView listView = (ListView) findViewById(R.id.listview);

    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        helper = new DatabaseHelper(this);

        Cursor c = helper.getEntries();

        if(c!=null)
        {
            c.moveToFirst();

            String[] columns = new String[]{"entrytitle","entrydesc","entrydatetime","entrylocation"};
            int[] to = new int[] {R.id.titleTV,R.id.dateTV,R.id.locationTV,R.id.editDesc};
            SimpleCursorAdapter mApdater = new SimpleCursorAdapter(this, R.layout.entries_row,c,columns,to, 0);
            this.setListAdapter(mApdater);
        }


    }
}
