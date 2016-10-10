package com.edavinci.wear.gregapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.fragments.SavedConfirmationFragment;
import com.edavinci.wear.gregapp.views.list.ListViewAdapter;
import com.edavinci.wear.gregapp.views.list.ListViewItem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements WearableListView.ClickListener {

    public static final String REMINDERS_LIST_FILENAME = "RemindersListFile1.dat";
    public static final int REMINDER_UNDER_WORK_INDEX = 0;

    private WearableListView listView;
    private MainActivity activityInstance;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInstance = this;

        setContentView(R.layout.activity_main);
        WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                listView = (WearableListView) stub.findViewById(R.id.wearable_list_view);
                List<ListViewItem> viewItemList = new ArrayList<ListViewItem>();
                viewItemList.add(new ListViewItem(R.drawable.ic_input_add, getString(R.string.create_reminder)));
                final Context context = getApplicationContext();
                List<ReminderDTO> savedReminders = SavedConfirmationFragment.getSavedReminders(context);
                for(ReminderDTO reminder : savedReminders){
                    System.err.println("reading from file: "+reminder);
                    viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, reminder.toShortString()));
                }
                // Assign an adapter to the list
                listView.setAdapter(new ListViewAdapter(stub.getContext(), viewItemList));

                // Set a click listener
                listView.setClickListener(activityInstance);
                listView.setGreedyTouchMode( true );
            }
            });
        }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Intent intent = new Intent(this, GridActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                ConfirmationActivity.SUCCESS_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    }

