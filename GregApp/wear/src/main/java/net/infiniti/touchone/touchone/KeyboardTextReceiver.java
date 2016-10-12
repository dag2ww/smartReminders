package net.infiniti.touchone.touchone;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.edavinci.wear.gregapp.activities.ReminderCardExtendedDisplay;

public class KeyboardTextReceiver extends BroadcastReceiver {
    public static final String CONTENT_TITLE = "contentText";

    public KeyboardTextReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra("Text");
        Toast.makeText(context, "Odebrano: "+text, Toast.LENGTH_SHORT).show();
    }
}
