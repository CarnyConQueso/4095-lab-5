package com.example.radio.ui.radio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radio.R;
import com.example.radio.controller.RadioAdapter;
import com.example.radio.model.RadioStation;
import com.example.radio.model.RadioList;

public class RadioFragment extends Fragment {

    private RadioViewModel radioViewModel;
    private RecyclerView recyclerView;
    private RadioAdapter adapter;
    public static RadioStation currRadio;
    public static RadioList radioList = new RadioList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        radioViewModel =
                new ViewModelProvider(this).get(RadioViewModel.class);
        View root = inflater.inflate(R.layout.fragment_radio, container, false);
        recyclerView= root.findViewById(R.id.stationsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new RadioAdapter(getContext(), radioList);
        recyclerView.setAdapter(adapter);
        currRadio= new RadioStation();
        radioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}