package net.infiniti.touchone.touchone;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.ReminderCardReceiver;
import com.edavinci.wear.gregapp.utils.ReminderDTO;
import com.edavinci.wear.gregapp.utils.PersistanceSupport;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class InputMethodSelectorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_box, container, false);
        Button input = (Button) view.findViewById(R.id.keyboardInput);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oneTouchKeyboardRequest = new Intent("appfour.intent.action.REQUEST_INPUT");
                //Intent oneTouchKeyboardRequest = new Intent(getContext(), DemoKeyboardActivity.class);
                oneTouchKeyboardRequest.addCategory("android.intent.category.DEFAULT");
                oneTouchKeyboardRequest.setPackage("net.infiniti.touchone.touchone");
                oneTouchKeyboardRequest.putExtra("Token", -1);
                startActivityForResult(oneTouchKeyboardRequest, 0);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String outcomeText = data.getStringExtra("OutcomeText");
        List<ReminderDTO> savedReminders = PersistanceSupport.getSavedReminders(getContext());
        savedReminders.get(0).message = outcomeText;
        PersistanceSupport.saveReminders(savedReminders, getContext());
        //Toast.makeText(getContext(), "Dotarło: " + data.getStringExtra("OutcomeText"), Toast.LENGTH_SHORT).show();
    }
}
