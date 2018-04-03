package com.example.rehaab.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Window;

public class Window3 extends AppCompatActivity {
    RecyclerView recyclerView;
    Data adapter;
    SQLiteDatabase sqLiteDatabase;
    FoundedHelper foundedHelper = new FoundedHelper(Window3.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window3);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sqLiteDatabase = foundedHelper.getWritableDatabase();
        addNote("kind", "30", "10", "010");
        Cursor cursor = getAllNotes();


        adapter = new Data(cursor, Window3.this);
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

//                long id = (long) viewHolder.itemView.getTag();
//
//                removeNote(id);
//
//                adapter.swapCursor(getAllNotes());
            }

        }).attachToRecyclerView(recyclerView);

    }

    //get all notes

    public void up(View view) {
        Intent intent = new Intent(Window3.this, Window5.class);
        startActivity(intent);
    }

    public void plu(View view) {
        Intent n = new Intent(Window3.this, Window4.class);
        startActivity(n);

    }

    public Cursor getAllNotes() {

        String[] projections = {FoundedContract.foundedEntry.COLUMN_KIND,
                FoundedContract.foundedEntry.COLUMN_NUMBERLOW,
                FoundedContract.foundedEntry.COLUMN_NUMBERNOW,
                FoundedContract.foundedEntry.NOMBER_PHONE};

        Cursor cursor = sqLiteDatabase.query(
                FoundedContract.foundedEntry.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                FoundedContract.foundedEntry._ID
        );
        cursor.moveToFirst();
        return cursor;
    }


    public long addNote(String kind, String numberNow, String numberLow, String numberPhone) {
        ContentValues cv = new ContentValues();
        cv.put(FoundedContract.foundedEntry.COLUMN_KIND, kind);
        cv.put(FoundedContract.foundedEntry.COLUMN_NUMBERNOW, numberNow);
        cv.put(FoundedContract.foundedEntry.COLUMN_NUMBERLOW, numberLow);
        cv.put(FoundedContract.foundedEntry.NOMBER_PHONE, numberPhone);
        return sqLiteDatabase.insert(FoundedContract.foundedEntry.TABLE_NAME, null, cv);


    }

    private boolean removeNote(long id) {
        return sqLiteDatabase.delete(FoundedContract.foundedEntry.TABLE_NAME, FoundedContract.foundedEntry._ID + "=" + id, null) > 0;
    }

    public void openAddNewNote() {
        Intent intent = new Intent(Window3.this, Window.class);
        startActivity(intent);
    }


}



