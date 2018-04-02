package com.wafaaelm3andy.pronote;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.wafaaelm3andy.pronote.NoteContract.* ;


/**
 * Created by wafaa on 2/15/2018.
 */

public class NoteDbHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase ;

    // The database name
    private static final String DATABASE_NAME = "notelist.db";
    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public NoteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold Notelist data
        final String SQL_CREATE_NOTELIST_TABLE = "CREATE TABLE " +  NotelistEntry.TABLE_NAME + " (" +
               NotelistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NotelistEntry.COLUMN_TITle + " TEXT NOT NULL, " +
                NotelistEntry.COLUMN_DETAILS + " TEXT NOT NULL, " +
                NotelistEntry.COLUMN_PURITY + " INTEGER NOT NULL " +
                "); ";

        //  Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_NOTELABLE
        sqLiteDatabase.execSQL(SQL_CREATE_NOTELIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NotelistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public long addNote(String title,String detials ,int purity){
        ContentValues cv = new ContentValues();
        cv.put(NotelistEntry.COLUMN_TITle,title );
        cv.put(NotelistEntry.COLUMN_DETAILS,detials);
        cv.put(NotelistEntry.COLUMN_PURITY,1);
        return sqLiteDatabase.insert(NoteContract.NotelistEntry.TABLE_NAME, null, cv);



    }
}
