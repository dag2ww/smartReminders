package com.edavinci.wear.gregapp.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.views.grid.SampleGridPagerAdapter;

import static java.security.AccessController.getContext;

public class EditMessage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_message_act);
        EditText input = (EditText)findViewById(R.id.edtInput);

                        input.requestFocus();

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showInputMethodPicker();
                        imm.getInputMethodList();
                        imm.getEnabledInputMethodList();
                        imm.showSoftInput(input, 0);
    }
}