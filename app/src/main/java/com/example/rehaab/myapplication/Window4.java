package com.example.rehaab.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Window4 extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    EditText ET1 ;
    EditText ET2 ;
    EditText ET3 ;
    EditText ET4 ;
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_window4));
        ET1 = (EditText) findViewById(R.id.editText1);
        ET2 = (EditText) findViewById(R.id.editText2);
        ET3 = (EditText) findViewById(R.id.editText3);
        ET4 = (EditText) findViewById(R.id.editText4);
        btn = (Button) findViewById(R.id.btn1);

        FoundedHelper mDBHelber = new FoundedHelper(this);
        sqLiteDatabase= mDBHelber.getWritableDatabase();
    }



    // sqLiteDatabase = noteDbHelper.getWritableDatabase();

    public void save(View view) {
        String kind =ET1.getText().toString();
        String  numberNow =ET2.getText().toString();
        String numberLow =ET3.getText().toString();
        String   numberPhone=ET4.getText().toString();

        addNote(kind,numberNow,numberLow,numberPhone);
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
        Intent i= new Intent(Window4.this,Window3.class);
        startActivity(i);
    }

    public long addNote(String kind,String numberNow ,String numberLow,String numberPhone){
        ContentValues cv = new ContentValues();
        cv.put(FoundedContract.foundedEntry.COLUMN_KIND,kind );
        cv.put(FoundedContract.foundedEntry.COLUMN_NUMBERNOW,numberNow);
        cv.put(FoundedContract.foundedEntry.COLUMN_NUMBERLOW,numberLow);
        cv.put(FoundedContract.foundedEntry.NOMBER_PHONE,numberPhone);

        return sqLiteDatabase.insert(FoundedContract.foundedEntry.TABLE_NAME,null, cv);



    }

}
