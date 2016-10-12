package com.edavinci.wear.gregapp.views.grid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.FragmentGridPagerAdapter;

import com.edavinci.wear.gregapp.R;
import com.edavinci.wear.gregapp.fragments.DatePickerFragment;
import net.infiniti.touchone.touchone.EditBoxFragment;

import com.edavinci.wear.gregapp.fragments.SavedConfirmationFragment;
import com.edavinci.wear.gregapp.fragments.TimePickerFragment;

import java.util.ArrayList;

public class SampleGridPagerAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;
    private ArrayList<SimpleRow> mPages;

    public SampleGridPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        initPages();
    }

    private void initPages() {
        mPages = new ArrayList<SimpleRow>();

        SimpleRow row1 = new SimpleRow();
        row1.addPages(new SimplePage("Title1", "Text1", R.mipmap.ic_launcher, R.mipmap.ic_launcher));
        row1.addPages(new SimplePage("Title2", "Text2", R.mipmap.ic_launcher, R.mipmap.ic_launcher));
        row1.addPages(new SimplePage("Title3", "Text3", R.mipmap.ic_launcher, R.mipmap.ic_launcher));
        row1.addPages(new SimplePage("Title4", "Text4", R.mipmap.ic_launcher, R.mipmap.ic_launcher));

        /*SimpleRow row2 = new SimpleRow();
        row2.addPages(new SimplePage("Title3", "Text3", R.mipmap.ic_launcher, R.mipmap.ic_launcher));

        SimpleRow row3 = new SimpleRow();
        row3.addPages(new SimplePage("Title4", "Text4", R.mipmap.ic_launcher, R.mipmap.ic_launcher));

        SimpleRow row4 = new SimpleRow();
        row4.addPages(new SimplePage("Title5", "Text5", R.mipmap.ic_launcher, R.mipmap.ic_launcher));
        row4.addPages(new SimplePage("Title6", "Text6", R.mipmap.ic_launcher, R.mipmap.ic_launcher));
*/
        mPages.add(row1);
        //mPages.add(row2);
        //mPages.add(row3);
        //mPages.add(row4);
    }

    @Override
    public Fragment getFragment(int row, int col) {
        SimplePage page = ((SimpleRow) mPages.get(row)).getPages(col);
      if(col == 0){
          return new TimePickerFragment();
      } else if(col == 1){
          return new DatePickerFragment();
      } else if(col == 2){
          return new EditBoxFragment();
      }else {
          return new SavedConfirmationFragment();
      }
     }


    @Override
    public int getRowCount() {
        return mPages.size();
    }

    @Override
    public int getColumnCount(int row) {
        return mPages.get(row).size();
    }
}
