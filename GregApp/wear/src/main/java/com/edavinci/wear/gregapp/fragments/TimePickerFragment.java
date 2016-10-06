package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
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
import java.util.concurrent.Exchanger;

import static com.edavinci.wear.gregapp.activities.MainActivity.REMINDERS_LIST_FILENAME;
import static com.edavinci.wear.gregapp.activities.MainActivity.REMINDER_UNDER_WORK_INDEX;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class TimePickerFragment extends Fragment{


    @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.time_picker, container, false);
            TimePicker timePicker = (TimePicker)view.findViewById(R.id.timePicker2);
            //TODO load the reminder under edit and preset time on the picker
            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    ObjectOutputStream oout = null;
                    ObjectInputStream oin = null;
                    ArrayList<ReminderDTO> savedReminders = new ArrayList<ReminderDTO>();
                    try {
                        FileInputStream fin = null;
                        try {
                        fin = container.getContext().openFileInput(REMINDERS_LIST_FILENAME);
                        oin = new ObjectInputStream(fin);
                        if(oin != null) {
                            savedReminders = (ArrayList<ReminderDTO>) oin.readObject();
                        }
                        } catch (Exception e){
                            //
                        }

                        if (savedReminders.size() == 0) {
                            savedReminders.add(0, new ReminderDTO());
                        }

                        savedReminders.get(REMINDER_UNDER_WORK_INDEX).hourOfday = hourOfDay;
                        savedReminders.get(0).minute = minute;
                        FileOutputStream fout = getContext().openFileOutput(REMINDERS_LIST_FILENAME, getContext().MODE_PRIVATE);
                        oout = new ObjectOutputStream(fout);
                        oout.writeObject(savedReminders);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            if (oout != null) {
                                oout.close();
                            }
                            if (oin != null) {
                                oin.close();
                            }
                        }catch (Exception e){
                            //
                        }
                    }
                }
            });
            return view;
        }

}
