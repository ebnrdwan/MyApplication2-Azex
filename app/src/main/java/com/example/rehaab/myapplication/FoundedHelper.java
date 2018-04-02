package com.example.rehaab.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SARA on 30/03/2018.
 */

public class FoundedHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase ;

    // The database name
    private static final String DATABASE_NAME = "notelist.db";
    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public FoundedHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold Notelist data
        final String SQL_CREATE_NOTELIST_TABLE = "CREATE TABLE " +  FoundedContract.foundedEntry.TABLE_NAME + " ( " +
                FoundedContract.foundedEntry ._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FoundedContract.foundedEntry.COLUMN_KIND + " TEXT NOT NULL, " +
                FoundedContract.foundedEntry.COLUMN_NUMBERNOW + " TEXT NOT NULL, " +
                FoundedContract.foundedEntry.COLUMN_NUMBERLOW + " INTEGER NOT NULL, " +
                FoundedContract.foundedEntry.NOMBER_PHONE+" TEXT NOT NULL " +
                "); ";
        sqLiteDatabase.execSQL(SQL_CREATE_NOTELIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FoundedContract.foundedEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public long addNote(String kind,String numberNow,int numberLow,int numberPhone ){
        ContentValues cv = new ContentValues();
        cv.put(FoundedContract.foundedEntry.COLUMN_KIND,kind );
        cv.put(FoundedContract.foundedEntry.COLUMN_NUMBERNOW,numberNow);
        cv.put(FoundedContract.foundedEntry.COLUMN_NUMBERLOW,numberLow);
        cv.put(FoundedContract.foundedEntry.NOMBER_PHONE,numberPhone);
        return sqLiteDatabase.insert(FoundedContract.foundedEntry.TABLE_NAME, null, cv);



    }


}

