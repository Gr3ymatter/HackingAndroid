package com.gr3ymatter.hackingandroid;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
public class MainActivity extends FragmentActivity implements ApiDemoFragment.OnFragmentInteractionListener, NotesFragment.OnFragmentInteractionListener{

    HackingAppPagerAdapter mHackingAppPagerAdapter;
    ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mHackingAppPagerAdapter = new HackingAppPagerAdapter(getSupportFragmentManager(),this);
        mViewPager.setAdapter(mHackingAppPagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);

        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabsFromPagerAdapter(mHackingAppPagerAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mViewPager.clearOnPageChangeListeners();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
