package com.example.rehaab.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by Rehaab on 30/03/2018.
 */

public class Notification {


    static final int ID = 0000 ;
    private static final int ID2 = 1111 ;


    private static PendingIntent contentIntent(Context context){

        Intent myIntent = new Intent ( context , SplashActivity.class ) ;


        return PendingIntent.getService (context , ID , myIntent , PendingIntent.FLAG_UPDATE_CURRENT ) ;
    }

    private static Bitmap largeIcon (Context context){

        Resources res = context.getResources () ;

        Bitmap lergeIcon = BitmapFactory.decodeResource (res , R.drawable.d1);
        return lergeIcon ;
    }


    public static void Nutification (Context context , String NotificationText , String NotificationTital){

        android.support.v4.app.NotificationCompat.Builder NB = new android.support.v4.app.NotificationCompat.Builder (context)
                .setColor (ContextCompat.getColor ( context ,R.color.colorPrimary))
                .setSmallIcon (R.drawable.d1)
                .setLargeIcon (largeIcon (context))
                .setContentTitle(NotificationTital)
                .setContentText (NotificationText)
                .setStyle (new android.support.v4.app.NotificationCompat.BigTextStyle ().bigText (
                        context.getString (R.string.text)))
                .setDefaults ( android.app.Notification.DEFAULT_VIBRATE )
                .setAutoCancel (true)
                .setContentIntent (contentIntent (context));




        if (Build.VERSION .SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            NB.setPriority ( android.app.Notification.PRIORITY_HIGH);
        }

        NotificationManager NM = (NotificationManager) context.getSystemService (context.NOTIFICATION_SERVICE);
        NM.notify (ID2 , NB.build());

    }


    public static void clearAllNotifications(Context context) {

    }
}
