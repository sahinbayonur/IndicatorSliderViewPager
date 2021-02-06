package com.sahinbay.sounds;

import android.app.Activity;
import android.util.DisplayMetrics;

public class Config {

    public static int getScreenDimensions(String dimen, Activity act) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (dimen.equals("height"))
            return displayMetrics.heightPixels;
        else
            return displayMetrics.widthPixels;

    }
}
