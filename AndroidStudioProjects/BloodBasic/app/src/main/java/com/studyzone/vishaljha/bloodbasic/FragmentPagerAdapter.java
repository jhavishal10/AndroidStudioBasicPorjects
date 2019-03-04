package com.studyzone.vishaljha.bloodbasic;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private Context context;

    public FragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0){
            return new Home();
        }else if (position==2) {
            return new fragment_About();
        }
        return new Profile();
    }

    @Override
    public CharSequence getPageTitle(int position) {
    String title=null;
        if (position==0){
            title="Home";
        }else if(position==1){
            title="Profile";
        }else if(position==2){
            title="About";
        }
        return title;
        }

    }


