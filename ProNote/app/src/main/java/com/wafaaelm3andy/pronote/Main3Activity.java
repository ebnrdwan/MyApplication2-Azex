package com.wafaaelm3andy.pronote;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner puritySpinner;
    EditText titleView , detailsView;
    SQLiteDatabase sqLiteDatabase ;
    MyAdapter myAdapter ;
    NoteDbHelper noteDbHelper ;
    int purity = 0 ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        puritySpinner = (Spinner) findViewById(R.id.purity_spinner);
        titleView=(EditText)findViewById(R.id.edit_title);
        detailsView=(EditText)findViewById(R.id.edit_details);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.purity, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        puritySpinner.setAdapter(adapter1);
        puritySpinner.setOnItemSelectedListener(this);

        noteDbHelper = new NoteDbHelper(this);
        open();
       // sqLiteDatabase = noteDbHelper.getWritableDatabase();



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sp1= String.valueOf(puritySpinner.getSelectedItem());
        if(sp1.contentEquals("low")) {
            Toast.makeText(this,"low",Toast.LENGTH_LONG).show();
            purity= 1;
    }
    else if (sp1.contentEquals("high")){
            purity= 4;
        }
        else if (sp1.contentEquals("Medium")){
            purity= 3;

        }
        else if (sp1.contentEquals("normal")){
            purity= 2;

        }
    }

    public void open() throws SQLException {
        sqLiteDatabase = noteDbHelper.getWritableDatabase();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void saveNote(View view){
        if (titleView.getText().length() == 0 ||
                detailsView.getText().length() == 0) {
            return;
        }
        String title = titleView.getText().toString();
        String details = detailsView.getText().toString();
        addNote(title,details,purity);

        //clear UI text fields
        titleView.clearFocus();
        detailsView.getText().clear();
        titleView.getText().clear();
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public long addNote(String title,String detials ,int purity){
        ContentValues cv = new ContentValues();
        cv.put(NoteContract.NotelistEntry.COLUMN_TITle,title );
        cv.put(NoteContract.NotelistEntry.COLUMN_DETAILS,detials);
        cv.put(NoteContract.NotelistEntry.COLUMN_PURITY,purity);
        return sqLiteDatabase.insert(NoteContract.NotelistEntry.TABLE_NAME,null, cv);



    }
}
