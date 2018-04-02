package com.example.rehaab.myapplication;


import android.content.Context;
import android.support.annotation.NonNull;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

import java.sql.Driver;
import java.sql.RowIdLifetime;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rehaab on 01/04/2018.
 */

public class jobScheduler {

    private static final int Internal_minutes = 15 ;
    private static final int Internal_Second = (int)(TimeUnit.MINUTES.toSeconds(Internal_minutes));
    private static final int FlexTime_second = Internal_Second;

    public static final String Reminder = "checking the Data";
    private static boolean sInitialized ;

    public jobScheduler(Driver driver) {

    }


    synchronized public static void Schadualing (final Context context){
    if(sInitialized) return;

     GooglePlayDriver driver = new GooglePlayDriver(context) ;
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);

        Job constraintReminderJob = dispatcher.newJobBuilder()
                .setService(Reminderclass.class)
                .setTag(Reminder)
                .setConstraints(Constraint.DEVICE_CHARGING)
                .setLifetime(Lifetime.FOREVER)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(0,1000))
                .setReplaceCurrent(true)
                .build();
        dispatcher.schedule(constraintReminderJob);
        sInitialized = true;
    }
}
