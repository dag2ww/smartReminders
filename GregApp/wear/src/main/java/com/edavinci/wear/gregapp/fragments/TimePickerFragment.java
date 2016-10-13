package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.utils.ReminderDTO;
import com.edavinci.wear.gregapp.utils.PersistanceSupport;

import java.util.List;

import static com.edavinci.wear.gregapp.activities.MainActivity.REMINDER_UNDER_WORK_INDEX;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class TimePickerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_picker, container, false);
        TimePicker timePicker = (TimePicker) view.findViewById(R.id.timePicker2);
        timePicker.setIs24HourView(true);
        final Context context = getActivity().getApplicationContext();

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                final List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(context);
                savedReminders.get(REMINDER_UNDER_WORK_INDEX).hourOfday = hourOfDay;
                savedReminders.get(REMINDER_UNDER_WORK_INDEX).minute = minute;
                PersistanceSupport.saveReminders(savedReminders, context);
            }
        });
        return view;
    }

}
