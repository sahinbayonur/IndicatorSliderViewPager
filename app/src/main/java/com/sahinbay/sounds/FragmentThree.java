package com.sahinbay.sounds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentThree extends Fragment {

    public FragmentThree(){
        Log.e("TAG", "FragmentThree Oluşturuldu");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.fragment_a, container, false);
        //return view;

        return inflater.inflate(R.layout.fragment_c, container, false);
    }
}
