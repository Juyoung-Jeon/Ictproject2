package com.example.ictproject.fragment_adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs; //tab의 갯수

    public MyPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment_one tab1 = new Fragment_one();
                return tab1;
            case 1:
                Fragment_two tab2 = new Fragment_two();
                return tab2;
            case 2:
                Fragment_three tab3 = new Fragment_three();
                return tab3;
            default:
                return null;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
