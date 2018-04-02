package com.example.rehaab.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Window2 extends AppCompatActivity {
    Button btn1 ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window2);
        btn1 = (Button) findViewById (R.id.btn1);

        btn1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent (Window2.this , Window3.class);
                startActivity (myIntent);
            }
        });
    }
}






