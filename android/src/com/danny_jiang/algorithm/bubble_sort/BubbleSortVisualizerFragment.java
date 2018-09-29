package com.danny_jiang.algorithm.bubble_sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danny_jiang.algorithm.R;

public class BubbleSortVisualizerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bubble_sort_visualizer_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BubbleSortVisualizerImageFragment fragment = new BubbleSortVisualizerImageFragment();
        FragmentTransaction trans = getChildFragmentManager().beginTransaction();
        trans.replace(R.id.visualizer, fragment);
        trans.commit();
    }
}
