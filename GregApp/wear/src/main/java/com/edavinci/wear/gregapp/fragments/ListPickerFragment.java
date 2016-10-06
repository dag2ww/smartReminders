package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.views.list.ListViewAdapter;
import com.edavinci.wear.gregapp.views.list.ListViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class ListPickerFragment extends Fragment implements WearableListView.ClickListener{
    // Sample dataset for the list
    String[] elements = { "List Item 1", "List Item 2", "List Item 3", "List Item 4" };
    private List<ListViewItem> viewItemList = new ArrayList<>();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View createdView = inflater.inflate(R.layout.wearable_list_view, container, false);
            // Get the list component from the layout of the activity
            WearableListView listView =
                    (WearableListView) createdView.findViewById(R.id.wearable_list_view);


            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Basketball"));
            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Baseball"));
            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Running"));
            viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, "Skateboard"));
            // Assign an adapter to the list
            listView.setAdapter(new ListViewAdapter(container.getContext(), viewItemList));

            // Set a click listener
            listView.setClickListener(this);
            listView.setGreedyTouchMode( true );
            return createdView;
        }

    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder v) {
            Toast.makeText(getContext(), "Click on " + viewItemList.get(v.getLayoutPosition()).text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTopEmptyRegionClick() {
    }

}
