package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.ReminderDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class DatePickerFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.date_picker, container, false);
            final Context context = getActivity().getApplicationContext();
            final List<ReminderDTO> savedReminders = SavedConfirmationFragment.getSavedReminders(context);
            final CalendarView calendarView = (CalendarView)view.findViewById(R.id.datePicker);
            savedReminders.get(0).date = new Date(calendarView.getDate());
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    savedReminders.get(0).date = new Date(calendarView.getDate());
                    SavedConfirmationFragment.saveReminders(savedReminders, context);
                }
            });
            return view;

        }

}
