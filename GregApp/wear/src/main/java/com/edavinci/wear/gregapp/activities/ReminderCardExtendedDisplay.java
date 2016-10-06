package com.edavinci.wear.gregapp.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.edavinci.wear.gregapp.R;

import java.util.Calendar;

public class ReminderCardExtendedDisplay extends Activity {

    private TextView mTextView;
    private ToggleButton mToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_notification);
        mTextView = (TextView) findViewById(R.id.text);
    }

}
