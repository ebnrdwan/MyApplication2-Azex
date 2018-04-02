package com.example.rehaab.myapplication;

import android.app.IntentService;
import android.content.Intent;



/**
 * Created by Rehaab on 01/04/2018.
 */

public class IS extends IntentService {

    public IS() {
        super("WaterReminderIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        Reminderclass.executeTask(this, action);
    }
}


