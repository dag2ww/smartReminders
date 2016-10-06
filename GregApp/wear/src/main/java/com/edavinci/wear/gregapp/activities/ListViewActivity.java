package com.edavinci.wear.gregapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.views.list.ListViewAdapter;
import com.edavinci.wear.gregapp.views.list.ListViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class ListViewActivity extends Activity implements WearableListView.ClickListener{
    // Sample dataset for the list
    String[] elements = { "List Item 1", "List Item 2", "List Item 3", "List Item 4" };
    private List<ListViewItem> viewItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wearable_list_view);

                WearableListView listView =
                    (WearableListView) findViewById(R.id.wearable_list_view);


            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Basketball"));
            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Baseball"));
            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Running"));
            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Skateboard"));
            // Assign an adapter to the list
            listView.setAdapter(new ListViewAdapter(this, viewItemList));

            // Set a click listener
            listView.setClickListener(this);
            listView.setGreedyTouchMode( true );

        }

    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder v) {
            Toast.makeText(this, "Click on " + viewItemList.get(v.getLayoutPosition()).text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTopEmptyRegionClick() {
    }

}
