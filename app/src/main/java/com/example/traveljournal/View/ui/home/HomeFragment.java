package com.example.traveljournal.View.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewTrips;
    private List<Trip> trips;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setDataSource();
        setLayoutManager();
        setAdapter();
        return view;
    }

    private void setAdapter() {
    }

    private void setLayoutManager() {
    }

    private void setDataSource() {
    }
}