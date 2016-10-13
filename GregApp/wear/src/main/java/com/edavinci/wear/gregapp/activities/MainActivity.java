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
import java.util.List;

public class MainActivity extends Activity implements WearableListView.ClickListener {

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
                List<ListViewItem> viewItemList = prepareRemindersList();
                listView = (WearableListView) stub.findViewById(R.id.wearable_list_view);
                listView.setAdapter(new ListViewAdapter(stub.getContext(), viewItemList));
                listView.setClickListener(activityInstance);
                listView.setGreedyTouchMode( true );
            }
            });
        }

    private List<ListViewItem> prepareRemindersList() {
        List<ListViewItem> viewItemList = new ArrayList<ListViewItem>();
        viewItemList.add(new ListViewItem(R.drawable.ic_input_add, getString(R.string.create_reminder)));

        List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(getApplicationContext());
        for(int i = 0; i < savedReminders.size(); i++){
            System.err.println("reading from file: "+savedReminders.get(i));
            if(i > 0) {
                viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, savedReminders.get(i).toShortString()));
            }
        }
        return viewItemList;
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

