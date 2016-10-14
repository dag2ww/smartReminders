package com.edavinci.wear.gregapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.utils.PersistanceSupport;
import com.edavinci.wear.gregapp.utils.ReminderDTO;
import com.edavinci.wear.gregapp.views.list.ListViewAdapter;
import com.edavinci.wear.gregapp.views.list.ListViewItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity implements WearableListView.ClickListener {

    public static final int REMINDER_UNDER_WORK_INDEX = 0;

    private WearableListView listView;
    private MainActivity activityInstance;
    ListViewAdapter dataAdapter;

    @Override
    public void onResume() {
        super.onResume();
        if (dataAdapter != null) {
            dataAdapter.reloadItems();
        }
    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInstance = this;

        setContentView(R.layout.activity_main);
        WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                dataAdapter = new ListViewAdapter(stub.getContext());
                dataAdapter.reloadItems();
                listView = (WearableListView) stub.findViewById(R.id.wearable_list_view);
                listView.setAdapter(dataAdapter);
                listView.setClickListener(activityInstance);
                listView.setGreedyTouchMode(true);
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

