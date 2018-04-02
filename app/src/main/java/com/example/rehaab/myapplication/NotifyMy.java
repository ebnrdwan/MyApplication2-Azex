package com.example.rehaab.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.action;
import static android.R.attr.inAnimation;

/**
 * Created by Rehaab on 30/03/2018.
 */

public class NotifyMy {


    public static void executeTask(Context context, String[] Kind, int[] NumberNow, int[] NumberLow
            , String[] NumberPhone) {

        int i = 0;
        /*
        * check for null values that we will use in our code ----->
        *             to avoid null pointer exceptions */
        if (Kind != null && NumberLow != null && NumberNow != null && NumberPhone != null) {
            while (i <= Kind.length) {

                String notificationText = " There is a low quantity of " + Kind[i];
                String notificationTital = " Founded !!! [ " + Kind[i] + "] ";

                String Message = " I need a new quantity of  " + Kind[i];

                if (NumberNow[i] == NumberLow[i]) {

                    com.example.rehaab.myapplication.Notification.Nutification(context, notificationText, notificationTital);

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(NumberPhone[i], null, Message, null, null);


                }

                i++;
            }

        }


    }


}
//}