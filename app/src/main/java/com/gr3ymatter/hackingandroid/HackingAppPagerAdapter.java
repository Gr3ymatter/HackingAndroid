package com.gr3ymatter.hackingandroid;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Afzal on 1/30/16.
 *
 * Adapters are responsible for handling how views are displayed in different AdapterViews. They hold information
 * such as how many counts of various views are present, request them to offer to the AdapterView when the time is right.
 * They also contain information on how to draw the child views.
 *
 * Think:
 *  ListView = AdapterView
 *  List Item = Child View
 *
 */
public class HackingAppPagerAdapter extends FragmentStatePagerAdapter {


    private int NUM_VIEWS = 2;
    private Context mContext;

    /*
    No Default Constructor Present So we create one ourselves using the super constructor.
    The Fragmentmanager is passed in to handle all the fragment manipulation
     */
    public HackingAppPagerAdapter(android.support.v4.app.FragmentManager fm, Context context){
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new ApiDemoFragment();
            case 1:
                return new NotesFragment();
            default:
                return new NotesFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_VIEWS;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                 return mContext.getString(R.string.api_demo_title);
            case 1:
                return mContext.getString(R.string.notes_title);
            default:
                return "Unknown Tab";
        }    }
}
