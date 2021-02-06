package com.sahinbay.sounds;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private final int ITEMS = 3;

    public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new FragmentOne();

            case 1:
                return new FragmentTwo();

            case 2:
                return new FragmentThree();

            default:
                return new FragmentOne();
        }
    }

    @Override
    public int getCount() {
        return ITEMS;
    }
}
