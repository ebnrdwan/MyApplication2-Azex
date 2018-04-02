package com.example.rehaab.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Window5 extends AppCompatActivity {
    Spinner spinner;
    String[]Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window5);

         spinner =(Spinner) findViewById(R.id.spinner);
        String[]Data={};
        ArrayAdapter<String>myAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Data);
        spinner.setAdapter(myAdapter);


    }
}
