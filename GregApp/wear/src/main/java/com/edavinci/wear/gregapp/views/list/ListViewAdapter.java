package com.edavinci.wear.gregapp.views.list;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.ViewGroup;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.utils.PersistanceSupport;
import com.edavinci.wear.gregapp.utils.ReminderDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public final class ListViewAdapter extends WearableListView.Adapter {
    private Context context;
    private List<ListViewItem> listViewItems;

    public ListViewAdapter(Context context) {
        this.context = context;
    }




    public void reloadItems(){
        listViewItems = prepareRemindersList();
        notifyDataSetChanged();
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new WearableListView.ViewHolder(new ListViewRowView(context));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int i) {
        ListViewRowView listViewRowView = (ListViewRowView) viewHolder.itemView;
        final ListViewItem listViewItem = listViewItems.get(i);

        listViewRowView.getImage().setImageResource(listViewItem.imageRes);
        listViewRowView.getText().setText(listViewItem.text);
    }

    @Override
    public int getItemCount() {
        return listViewItems.size();
    }

    private List<ListViewItem> prepareRemindersList() {
        List<ListViewItem> viewItemList = new ArrayList<ListViewItem>();
        viewItemList.add(new ListViewItem(R.drawable.ic_input_add, context.getString(R.string.create_reminder)));

        List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(context);
        for(int i = 0; i < savedReminders.size(); i++){
            System.err.println("reading from file: "+savedReminders.get(i));
            if(i > 0) {
                ReminderDTO reminder = savedReminders.get(i);
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, reminder.year);
                calendar.set(Calendar.MONTH, reminder.month);
                calendar.set(Calendar.DAY_OF_MONTH, reminder.day);
                calendar.set(Calendar.HOUR_OF_DAY, reminder.hourOfday);
                calendar.set(Calendar.MINUTE, reminder.minute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                if(calendar.after(Calendar.getInstance())) {
                    viewItemList.add(new ListViewItem(R.mipmap.ic_launcher, savedReminders.get(i).toShortString()));
                } else {
                    savedReminders.remove(i);
                }
            }
        }
        PersistanceSupport.saveReminders(savedReminders, context);
        return viewItemList;
    }

}
