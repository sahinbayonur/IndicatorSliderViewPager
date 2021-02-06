package com.sahinbay.sounds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    GridAdapter adapter;
    RecyclerView.OnItemTouchListener listener;
    List<Item> itemsList;
    int[] randomOne = {0, 13};
    ArrayList listitems = new ArrayList();
    int a = 0;

    public FragmentOne(){
        Log.e("TAG", "FragmentOne Oluşturuldu");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        Log.e("TAG", "onCreateView");

        /*recyclerView = view.findViewById(R.id.recycler_view);

        itemsList = new ArrayList<>();
        itemsList.add(new Item(0, R.raw.beach, R.drawable.bird, false, false));
        itemsList.add(new Item(1, R.raw.birds, R.drawable.bird, false, false));
        itemsList.add(new Item(2, R.raw.fire, R.drawable.bird, false, false));
        itemsList.add(new Item(3, R.raw.sheep, R.drawable.bird, false, true));
        itemsList.add(new Item(4, R.raw.river, R.drawable.bird, false, false));
        itemsList.add(new Item(5, R.raw.drops, R.drawable.bird, false, false));
        itemsList.add(new Item(6, R.raw.forest, R.drawable.bird, false, false));
        itemsList.add(new Item(7, R.raw.leaves, R.drawable.bird, false, true));
        itemsList.add(new Item(8, R.raw.pinknoise, R.drawable.bird, true, true));
        itemsList.add(new Item(9, R.raw.brownnoise, R.drawable.bird, false, true));
        itemsList.add(new Item(10, R.raw.rain, R.drawable.bird, false, false));
        itemsList.add(new Item(11, R.raw.thunder, R.drawable.bird, true, true));
        itemsList.add(new Item(12, R.raw.cat_purr, R.drawable.bird, false, true));
        itemsList.add(new Item(13, R.raw.windchimes, R.drawable.bird, false, false));

        listitems.add(randomOne);

        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new GridAdapter(getActivity(), itemsList);
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setAdapter(adapter);*/

        /*if (a == 0) {
            a++;
            recyclerView.setAdapter(adapter);
        }*/

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
