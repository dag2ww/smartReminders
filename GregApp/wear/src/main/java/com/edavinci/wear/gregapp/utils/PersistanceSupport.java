package com.edavinci.wear.gregapp.utils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by g.dancewicz on 13/10/16.
 */

public class PersistanceSupport {
    public static final String REMINDERS_LIST_FILENAME = "RemindersListFile1.dat";

    public static List<ReminderDTO> getSavedReminders(Context context) {
        ArrayList<ReminderDTO> savedReminders = new ArrayList<ReminderDTO>();

        savedReminders = getRemindersFromFile(context, savedReminders);

        if (savedReminders.size() == 0) {
            savedReminders.add(0, new ReminderDTO());
        }

        return savedReminders;
    }

    private static ArrayList<ReminderDTO> getRemindersFromFile(Context context, ArrayList<ReminderDTO> savedReminders) {
        ObjectInputStream oin = null;
        FileInputStream fin = null;
        try {
            fin = context.openFileInput(REMINDERS_LIST_FILENAME);
            oin = new ObjectInputStream(fin);
            if (oin != null) {
                savedReminders.addAll((ArrayList<ReminderDTO>) oin.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (oin != null) {
                oin.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savedReminders;
    }

    public static void saveReminders(List<ReminderDTO> reminders, Context context) {
        ObjectOutputStream oout = null;
        try {
            FileOutputStream fout = context.openFileOutput(REMINDERS_LIST_FILENAME, context.MODE_PRIVATE);
            oout = new ObjectOutputStream(fout);
            oout.writeObject(reminders);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oout != null) {
                    oout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
