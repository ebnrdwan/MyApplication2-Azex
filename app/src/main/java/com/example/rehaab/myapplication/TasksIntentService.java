package com.example.rehaab.myapplication;

import android.app.IntentService;
import android.content.Intent;



/**
 * Created by Rehaab on 01/04/2018.
 */

public class TasksIntentService extends IntentService {

    public TasksIntentService() {
        super("TasksIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        MyJobScheduler.executeTask(this, action);
    }
}


