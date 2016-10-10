package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.ReminderDTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import static com.edavinci.wear.gregapp.activities.MainActivity.REMINDERS_LIST_FILENAME;
import static com.edavinci.wear.gregapp.activities.MainActivity.REMINDER_UNDER_WORK_INDEX;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class TimePickerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_picker, container, false);
        TimePicker timePicker = (TimePicker) view.findViewById(R.id.timePicker2);
        final Context context = getActivity().getApplicationContext();

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                final List<ReminderDTO> savedReminders = SavedConfirmationFragment.getSavedReminders(context);
                savedReminders.get(REMINDER_UNDER_WORK_INDEX).hourOfday = hourOfDay;
                savedReminders.get(REMINDER_UNDER_WORK_INDEX).minute = minute;
                SavedConfirmationFragment.saveReminders(savedReminders, context);
            }
        });
        return view;
    }

}
