package com.example.rehaab.myapplication;


import android.content.Context;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rehaab on 01/04/2018.
 */

public class MyJobScheduler {

    private static final int intervalHours = 8 ;
    private static final int Interval_Second = (int)(TimeUnit.HOURS.toSeconds(intervalHours));
    private static final int FlexTime_second = Interval_Second;
    public static final String Reminder = "checking the Data";
    private static boolean sInitialized ;
    // specific  action String to do some work
    public static String ACTION_NOTIFICATION="notify_Action";
    public static String ACTION_NOTIFICATION_DISMISS="notify_cancel";


    public static void executeTask(Context context, String action) {
        if (ACTION_NOTIFICATION.equals(action)){
            // do some work
        }
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
                .setTrigger(Trigger.executionWindow(Interval_Second, Interval_Second +FlexTime_second))
                .build();
        dispatcher.schedule(constraintReminderJob);
        sInitialized = true;
    }
}
