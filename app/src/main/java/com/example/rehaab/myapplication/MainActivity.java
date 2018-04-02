package com.example.rehaab.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText ET1;
    EditText ET2;
    EditText ET3;
    EditText ET4;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ET1 = (EditText) findViewById(R.id.ET1);
//        ET2 = (EditText) findViewById(R.id.ET2);
//        ET3 = (EditText) findViewById(R.id.ET3);
//        ET4 = (EditText) findViewById(R.id.ET4);
//        btn = (Button) findViewById(R.id.btn);

      jobScheduler.Schadualing(this);
    }

//protected void onResume(){
//    super.onResume();
//
//    String str1 = ET1.getText().toString();
//    String str2 = ET2.getText().toString();
//
//    Notification(this , str1 , str2);
//}

    public void Notification (Context context , String str1 , String str2 ) {
        try {
            if (str1.equals(str2)
                    && str2 != null) {
//                Notification.Nutification(context);
            }
        } catch (Exception e) {

            Toast.makeText(context , "There is error", Toast.LENGTH_LONG).show();

        }
    }
//
//    public void GO(View view) {
//        try {
//            if (ET1.getText().toString().equals(null)){
//               ET1.setText(" أدخل الإسم الصحيح حتى يكتمل التخزين");
//            }
//            else if (ET2.getText().toString().equals(null)){
//                ET2.setText("أدخل الرقم الصحيح حتى يكتمل التخزين ");
//            }
//            else if(ET3.getText().toString().equals(null)){
//                ET3.setText("أدخل الحد الأدنى حتى يكتمل التخزين");
//            }
//            else if(ET4.getText().toString().equals(null)){
//                ET4.setText("أدخل رقم الهاتف الصحيح حتى يكتمل التخزين");
//            }
//
//            else if (ET2.getText().toString().equals(ET3.getText().toString())
//                    && ET2.getText().toString()!=null) {
//
//            } else {
//                Toast.makeText(this ,"Data saved" ,Toast.LENGTH_LONG).show();
//                ET1.setText("");
//                ET2.setText("");
//                ET3.setText("");
//                ET4.setText("");
//
//            }
//        }catch (Exception e){
//
//            Toast.makeText(this ,"There is error" ,Toast.LENGTH_LONG).show();
//
//        }
//    }
}