package com.weeaisin.android.icecreamrecipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by AiLeng on 05-Mar-17.
 */

public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
   // int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        //this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                //Tab1 tab1 = new Tab1();
                return new Tab1();
            case 1:
               // Tab2 tab2 = new Tab2();
                return new Tab2();
            case 2:
                //Tab3 tab3 = new Tab3();
                return new Tab3();
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return 3;
    }
}
