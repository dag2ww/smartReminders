package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.ReminderDTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.edavinci.wear.gregapp.activities.MainActivity.REMINDERS_LIST_FILENAME;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class SavedConfirmationFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View result = inflater.inflate(R.layout.save_reminder, container, false);
            result.findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ConfirmationActivity.class);
                    intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                            ConfirmationActivity.SUCCESS_ANIMATION);
                    intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,
                            R.string.reminder_created);

                    List<ReminderDTO> savedReminders = getSavedReminders(container);
                    savedReminders.add(savedReminders.get(0));
                    saveReminders(savedReminders,container);
                    startActivity(intent);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    getActivity().onBackPressed();
                }
            });


            return result;

        }

    public static List<ReminderDTO> getSavedReminders(ViewGroup container) {
        ObjectInputStream oin = null;
        ArrayList<ReminderDTO> savedReminders = new ArrayList<ReminderDTO>();
        try {
            FileInputStream fin = null;
            try {
                fin = container.getContext().openFileInput(REMINDERS_LIST_FILENAME);
                oin = new ObjectInputStream(fin);
                if (oin != null) {
                    savedReminders = (ArrayList<ReminderDTO>) oin.readObject();
                }
            } catch (Exception e) {
                //
            }

            if (savedReminders.size() == 0) {
                savedReminders.add(0, new ReminderDTO());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                oin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return savedReminders;
    }

    public static void saveReminders(List<ReminderDTO> reminders, ViewGroup container) {
        ObjectOutputStream oout = null;
        try {
            FileInputStream fin = null;
            try {
                FileOutputStream fout = container.getContext().openFileOutput(REMINDERS_LIST_FILENAME, container.getContext().MODE_PRIVATE);
                oout = new ObjectOutputStream(fout);
                oout.writeObject(reminders);
            } catch (Exception e) {
                //
            }
            if (reminders.size() == 0) {
                reminders.add(0, new ReminderDTO());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                oout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
