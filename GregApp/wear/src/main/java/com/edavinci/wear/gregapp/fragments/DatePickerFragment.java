package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.MainActivity;
import com.edavinci.wear.gregapp.utils.ReminderDTO;
import com.edavinci.wear.gregapp.utils.PersistanceSupport;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class DatePickerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_picker, container, false);
        final CalendarView calendarView = (CalendarView) view.findViewById(R.id.datePicker);

        initCurrentDate(calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                final List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(getContext());
                savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX).year = year;
                savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX).month = month;
                savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX).day = dayOfMonth;
                PersistanceSupport.saveReminders(savedReminders, getContext());
            }
        });
        return view;

    }

    private void initCurrentDate(CalendarView calendarView) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(calendarView.getDate()));
        final List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(getContext());
        savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX).year = calendar.get(Calendar.YEAR);
        savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX).month = calendar.get(Calendar.MONTH);;
        savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX).day = calendar.get(Calendar.DAY_OF_MONTH);;
        PersistanceSupport.saveReminders(savedReminders, getContext());
    }

}
