package com.example.sylviawan.traveldiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.sql.SQLException;

import static android.R.attr.description;

// Database

public class DatabaseHelper extends SQLiteOpenHelper {

    //DATABASE NAME/VERSION
    private static final String DATABASE_NAME = "DiaryDatabase";
    //private static final String DATABASE_VERSION = "1";

    //The tables in the Travel Diary database
    private static final String TABLE_USER = "users";
    private static final String TABLE_USERENTRIES = "entries";

    //USER TABLE
    private static final String USER_ID = "userid";
    private static final String USER_NAME = "username";
    private static final String USER_PASSWORD = "userpassword";

    //ENTRIES TABLE
    private static final String _ID = "_id";
    private static final String ENTRY_TITLE = "entrytitle";
    private static final String ENTRY_DESCRIPTION = "entrydesc";
    private static final String ENTRY_DATETIME = "entrydatetime";
    private static final String ENTRY_LOCATION = "entrylocation";

    // Attempt to use ENTRY_PHOTO
    //private static final String ENTRY_PHOTO = "entryphoto";

    // constructor
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onConfigure (SQLiteDatabase db){
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Creating the tables
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USER +
                "( " +
                USER_ID + " INTEGER PRIMARY KEY, " +
                USER_NAME + " TEXT, " + //Username used to LOGIN
                USER_PASSWORD + " TEXT " + //User password used to LOGIN
                ");";

        String CREATE_ENTRIES_TABLE = "CREATE TABLE " + TABLE_USERENTRIES +
                "( " +
                _ID + " INTEGER PRIMARY KEY autoincrement, " +
                ENTRY_TITLE + " TEXT, " +
                ENTRY_DESCRIPTION + " TEXT, " +
                ENTRY_DATETIME + " INTEGER, " +
                ENTRY_LOCATION + " TEXT " +
                ");";

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_ENTRIES_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERENTRIES);
        this.onCreate(db);

    }

    // Code to insert a user
    public void insertUser(User u)
    {
        String uname = u.getName().toString();
        String pass = u.getPass().toString();
        Log.e("This is the uname", uname);
        Log.e("This is the pass",pass);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME ", uname); //Username
        contentValues.put("userpassword ", pass); //Password

        //Insert Rows
        db.insert(TABLE_USER, null, contentValues);
        db.close();
    }

    // Insert a new entry
    public void insertUserEntries(Entry en)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ENTRY_TITLE", en.getTitle());
        contentValues.put("ENTRY_DESCRIPTION",en.getDesc());
        contentValues.put("ENTRY_DAYTIME", en.getDate());
        contentValues.put("ENTRY_LOCATION", en.getLocation());
        db.insert(TABLE_USERENTRIES, null, contentValues);
    }

    //Update users
    public int updateUsers(User u)
    {
        String uname = u.getName().toString();
        String pass = u.getPass().toString();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", uname);
        contentValues.put("userpassword", pass);
        db.update(TABLE_USER, contentValues, "_id = ?", new String[]{uname});
        return 0;
    }


    // Code to delete an entry from the database
    public Integer deleteData(String table, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table, "_id = ?", new String[]{id});
    }


    public String searchPass(String uname, String pass)
    {
        Log.e("Inside DB Helper", pass);
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT USERNAME, userpassword FROM " + TABLE_USER;
        Cursor res = db.rawQuery(query, null);
        if(res != null)
        {
            if(res.moveToFirst())
            {
                do {
                    uname = res.getString(0);

                    if (uname.equals(uname)) {
                        pass = res.getString(1);
                        break;
                    }
                }
                while (res.moveToNext());
            }
        }
        else
        {
            pass = "Not Found";
        }

        return pass;
    }

    // Cursor to get Entries
    public Cursor getEntries()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_USERENTRIES, new String[]{
                        _ID,
                        ENTRY_TITLE,
                        ENTRY_DESCRIPTION,
                        ENTRY_DATETIME,
                        ENTRY_LOCATION},
                null,
                null,
                null,
                null,
                null);
    }

}



