package com.edavinci.wear.gregapp.fragments;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.MainActivity;
import com.edavinci.wear.gregapp.activities.ReminderCardReceiver;
import com.edavinci.wear.gregapp.utils.ReminderDTO;
import com.edavinci.wear.gregapp.utils.PersistanceSupport;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class SavedConfirmationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateContentView(inflater, container, savedInstanceState);
        View result = inflater.inflate(R.layout.save_reminder, container, false);
        ImageButton createReminderButton = (ImageButton) result.findViewById(R.id.saveButton);

        createReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showSuccessIntent = new Intent(getContext(), ConfirmationActivity.class);
                showSuccessIntent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                        ConfirmationActivity.SUCCESS_ANIMATION);
                showSuccessIntent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,
                        R.string.reminder_created);

                createReminderListItemAndAlarm();

                startActivity(showSuccessIntent);
                getActivity().onBackPressed();
            }
        });

        return result;

    }

    private void createReminderListItemAndAlarm() {
        List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(getContext());
        ReminderDTO createdReminder = new ReminderDTO(savedReminders.get(MainActivity.REMINDER_UNDER_WORK_INDEX));
        savedReminders.add(createdReminder);
        PersistanceSupport.saveReminders(savedReminders, getContext());
        createAlarm(createdReminder);
    }

    private void createAlarm(ReminderDTO reminder) {
        AlarmManager alarmMgr = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(getContext(), ReminderCardReceiver.class);
        intent.putExtra(ReminderCardReceiver.CONTENT_TITLE, reminder.message);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, reminder.year);
        calendar.set(Calendar.MONTH, reminder.month);
        calendar.set(Calendar.DAY_OF_MONTH, reminder.day);
        calendar.set(Calendar.HOUR_OF_DAY, reminder.hourOfday);
        calendar.set(Calendar.MINUTE, reminder.minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        alarmMgr.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
    }
}
