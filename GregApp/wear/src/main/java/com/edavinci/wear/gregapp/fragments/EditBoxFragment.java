package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.activities.EditMessage;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class EditBoxFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.edit_box, container, false);
            Button input = (Button)view.findViewById(R.id.keyboardInput);
           input.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getContext(), EditMessage.class);
                   startActivity(intent);
               }
           });
//            input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) {
//                    if(hasFocus){
//                        EditText input = (EditText)v.findViewById(R.id.reminderMessage);
//
//                        input.requestFocus();
//
//                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
//                        imm.showInputMethodPicker();
//                        imm.getInputMethodList();
//                        imm.getEnabledInputMethodList();
//                        imm.showSoftInput(input, 0);
//                    }
//                }
//            });
            return view;

        }

}
