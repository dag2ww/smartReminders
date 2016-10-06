package com.edavinci.wear.gregapp.views.list;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edavinci.wear.gregapp.R;

/**
 * Created by Grzegorz on 2016-09-30.
 */

    public class WearableListItemLayout extends LinearLayout
            implements WearableListView.OnCenterProximityListener {

        private ImageView mCircle;
        private TextView mName;

        private final float mFadedTextAlpha;
        private final int mFadedCircleColor;
        private final int mChosenCircleColor;

        public WearableListItemLayout(Context context) {
            this(context, null);
        }

        public WearableListItemLayout(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public WearableListItemLayout(Context context, AttributeSet attrs,
                                      int defStyle) {
            super(context, attrs, defStyle);

            mFadedTextAlpha = 50 / 100f;
            mFadedCircleColor = getResources().getColor(R.color.grey);
            mChosenCircleColor = getResources().getColor(R.color.blue);
        }

        // Get references to the icon and text in the item layout definition
        @Override
        protected void onFinishInflate() {
            super.onFinishInflate();
            // These are defined in the layout file for list items
            // (see next section)
            mCircle = (ImageView) findViewById(R.id.image);
            mName = (TextView) findViewById(R.id.text);
        }

        @Override
        public void onCenterPosition(boolean animate) {
            mName.setAlpha(1f);
           // ((GradientDrawable) mCircle.getDrawable()).setColor(mChosenCircleColor);
        }

        @Override
        public void onNonCenterPosition(boolean animate) {
             //mCircle.getDrawable().setColor(mFadedCircleColor);
            mName.setAlpha(mFadedTextAlpha);
        }
    }
