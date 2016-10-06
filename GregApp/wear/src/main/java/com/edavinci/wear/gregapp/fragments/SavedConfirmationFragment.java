package com.edavinci.wear.gregapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edavinci.wear.gregapp.R;

/**
 * Created by Grzegorz on 2016-09-30.
 */

public class SavedConfirmationFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //super.onCreateContentView(inflater, container, savedInstanceState);
            View result = inflater.inflate(R.layout.save_reminder, container, false);
            result.findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ConfirmationActivity.class);
                    intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                            ConfirmationActivity.SUCCESS_ANIMATION);
                    intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,
                            "GOTOWE");
                    //TODO copy working item as new item and save the list
                    startActivity(intent);
                    getActivity().onBackPressed();
                }
            });


            return result;

        }

}
