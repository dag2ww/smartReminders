package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.edavinci.wear.gregapp.R;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class EditBoxFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.edit_box, container, false);

            return view;

        }

}
