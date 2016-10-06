package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.edavinci.wear.gregapp.R;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class DatePickerFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.date_picker, container, false);
            final CalendarView calendarView = (CalendarView)view.findViewById(R.id.datePicker);
            calendarView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    //Todo find proper listener to have data even without any chane of date
                    calendarView.getDate();
                }

                @Override
                public void onViewDetachedFromWindow(View v) {

                }
            });
            return view;

        }

}
