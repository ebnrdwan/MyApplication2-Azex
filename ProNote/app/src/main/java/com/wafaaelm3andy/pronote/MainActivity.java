package com.wafaaelm3andy.pronote;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements MyAdapter.ListItemClickListener {
RecyclerView recyclerView ;
    MyAdapter adapter ;
    SQLiteDatabase sqLiteDatabase ;
    NoteDbHelper noteDbHelper=new NoteDbHelper(MainActivity.this);
    int flag = 0 ;
    SharedPreferences sharedPreferences  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddNewNote();
            }
        });

        sqLiteDatabase = noteDbHelper.getWritableDatabase();
        Cursor cursor = getAllNotes();


       adapter = new MyAdapter(cursor,MainActivity.this,MainActivity.this);
       recyclerView.setAdapter(adapter);



        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                long id = (long) viewHolder.itemView.getTag();

                removeNote(id);

                adapter.swapCursor(getAllNotes());
            }

        }).attachToRecyclerView(recyclerView);
        sharedPreferences = getSharedPreferences("flag", Context.MODE_PRIVATE);
        sharedPreferences.edit();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        flag=sharedPreferences.getInt("flag",0);
        if(flag==0){
            addfakeNote ();
        }

        editor.putInt("flag",1);
        editor.apply();
        flag= sharedPreferences.getInt("flag",1);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(this, "item clicked", Toast.LENGTH_LONG).show();

    }

    //get all notes
    public Cursor getAllNotes(){
        return sqLiteDatabase.query(
                NoteContract.NotelistEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                NoteContract.NotelistEntry._ID
        );
    }


    public long addNote(String title,String detials ,int purity){
        ContentValues cv = new ContentValues();
        cv.put(NoteContract.NotelistEntry.COLUMN_TITle,title );
        cv.put(NoteContract.NotelistEntry.COLUMN_DETAILS,detials);
        cv.put(NoteContract.NotelistEntry.COLUMN_PURITY,1);
        return sqLiteDatabase.insert(NoteContract.NotelistEntry.TABLE_NAME,null, cv);



    }
    private boolean removeNote(long id) {
        return sqLiteDatabase.delete(NoteContract.NotelistEntry.TABLE_NAME, NoteContract.NotelistEntry._ID + "=" + id, null) > 0;
    }
    public void openAddNewNote() {
        Intent intent = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent);
        }
        public void addfakeNote () {
        addNote("النية ", "راقب قلبك ",3);
        addNote("القران الكريم ","اجعل القران مؤنسك",5);
        addNote(" ابو الدراداء"," ان لنا دارا اليها نرجع ",4);

    }

    }
