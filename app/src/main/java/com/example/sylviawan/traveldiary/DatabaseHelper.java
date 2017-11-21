package com.example.sylviawan.traveldiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.sql.SQLException;

/**
 * Created by sylviawan on 21/11/2017.
 */



public class DatabaseHelper extends SQLiteOpenHelper {

    /*DATABASE NAME/VERSION*/
    private static final String DATABASE_NAME = "DiaryDatabase";
    //private static final String DATABASE_VERSION = "1";

    /*TABLES IN DATABASE*/
    private static final String TABLE_USER = "users";
    private static final String TABLE_USERENTRIES = "entries";

    /*USER TABLE COLUMNS*/
    private static final String USER_ID = "userid";
    private static final String USER_NAME = "username";
    private static final String USER_PASSWORD = "userpassword";

    /*ENTRIES TABLE COLUMNS*/
    private static final String ENTRY_ID = "entryid";
    private static final String ENTRY_ID_FK = "entryidFK";
    private static final String ENTRY_TITLE = "entrytitle";
    private static final String ENTRY_DESCRIPTION = "entrydesc";
    private static final String ENTRY_DATETIME = "entrydatetime";
    private static final String ENTRY_LOCATION = "entrylocation";

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

    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USER +
                "(" +
                USER_ID + " INTEGER PRIMARY KEY," + //UserID is a Primary Key in USER Tables
                USER_NAME + " TEXT," + //Username used to LOGIN
                USER_PASSWORD + " TEXT," + //User password used to LOGIN
                ")";

        String CREATE_ENTRIES_TABLE = "CREATE TABLE " + TABLE_USERENTRIES +
                "(" +
                ENTRY_ID + " INTEGER PRIMARY KEY," + //ENTRY_ID is a Primary Key in USERENTRIES Table
                ENTRY_ID_FK + " INTEGER REFERENCES " + TABLE_USER + "," + //ENTRY_ID_FK is a foreign key to the USER Table
                ENTRY_TITLE + " TEXT," + //ENTRY_ID is a Primary Key in USERENTRIES Tabl
                ENTRY_DESCRIPTION + " TEXT," + //ENTRY_ID is a Primary Key in USERENTRIES Table
                ENTRY_DATETIME + " INTEGER," + //ENTRY_ID is a Primary Key in USERENTRIES Table
                ENTRY_LOCATION + " TEXT," + //ENTRY_ID is a Primary Key in USERENTRIES Table
                ")";

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_ENTRIES_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        if (oldVer != newVer){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERENTRIES);
        }
    }
    public boolean insertUser(String name, String password, String email, String userno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USER_NAME", name);
        contentValues.put("USER_PASSWORD", password);
        contentValues.put("USERID", userno);
        long res = db.insert(TABLE_USER, null, contentValues);
        if (res == -1)
            return false;
        else
            return true;
    }

    public boolean insertUserEntries(String title, String description, String daytime, String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ENTRY_TITLE", title);
        contentValues.put("ENTRY_DESCRIPTION", description);
        contentValues.put("ENTRY_DAYTIME", daytime);
        contentValues.put("ENTRY_LOCATION", location);
        long res = db.insert(TABLE_USERENTRIES, null, contentValues);
        if (res == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean updateUsers(String id, String userno, String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USER_NAME", name);
        contentValues.put("USER_PASSWORD", password);
        contentValues.put("USER_ID", userno);
        db.update(TABLE_USER, contentValues, "_id = ?", new String[]{id});
        return true;
    }

    public boolean updateUserEntries(String id, String title, String description, String daytime, String location){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ENTRY_TITLE", title);
        contentValues.put("ENTRY_DESCRIPTION", description);
        contentValues.put("ENTRY_DAYTIME", daytime);
        contentValues.put("ENTRY_LOCATION", location);
        db.update(TABLE_USERENTRIES, contentValues, "_id = ?", new String[]{id});
        return true;
    }

    public Integer deleteData(String table, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table, "_id = ?", new String[]{id});
    }

}
