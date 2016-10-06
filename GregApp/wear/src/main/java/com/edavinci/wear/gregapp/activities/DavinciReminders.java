package com.edavinci.wear.gregapp.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TimePicker;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.ReminderCardReceiver;

import java.util.Calendar;

/**
 * Example shell activity which simply broadcasts to our receiver and exits.
 */
public class DavinciReminders extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent();
        //for receiver intent filter
        i.setAction("com.edavinci.wear.gregapp.SHOW_NOTIFICATION");
        i.putExtra(ReminderCardReceiver.CONTENT_TITLE, getString(R.string.title));
        sendBroadcast(i);
        //TODO periodically check dat time_picker and fire notifications if any deserve
        //TODO Maybe start a service here to do above ?
        finish();
    }
}
