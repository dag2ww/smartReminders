package com.edavinci.wear.gregapp.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.ReminderCardExtendedDisplay;

import static android.app.Notification.PRIORITY_MAX;

public class ReminderCardReceiver extends BroadcastReceiver {
    public static final String CONTENT_TITLE = "contentText";

    public ReminderCardReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent displayIntent = new Intent(context, ReminderCardExtendedDisplay.class);
        String cardPopTitle = intent.getStringExtra(CONTENT_TITLE);
        Notification notification = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(cardPopTitle)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000}).setPriority(PRIORITY_MAX)
                .extend(new Notification.WearableExtender()
                        .setDisplayIntent(PendingIntent.getActivity(context, 0, displayIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT)))
                .build();
        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, notification);
        //Toast.makeText(context, context.getString(R.string.notification_posted), Toast.LENGTH_SHORT).show();
    }
}
