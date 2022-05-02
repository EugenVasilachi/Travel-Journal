package com.example.traveljournal.View.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;
import com.example.traveljournal.View.DrawerActivity;
import com.example.traveljournal.View.recicler_view.TripAdapter;
import com.example.traveljournal.View.recicler_view.TripListActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewTrips;
    private List<Trip> trips;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // !!!
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setupRecyclerViewTrips();

        /*setDataSource();
        setLayoutManager();
        setAdapter();*/
        return view;
    }

    private void getTrips() {
        trips = new ArrayList<>();
        Trip trip1 = new Trip("Calatorie 1", "Roma");
        Trip trip2 = new Trip("Calatorie 2", "Madrid");
        Trip trip3 = new Trip("Calatorie 3", "New York");

        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);

    }

    private TripAdapter getTripsAdapter() {
        return new TripAdapter(trips);
    }


    private void setupLayoutManager() {
        // !!!
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setupRecyclerViewTrips() {
        getTrips();
        setupLayoutManager();
        recyclerViewTrips.setAdapter(getTripsAdapter());
    }

    /*private void setAdapter() {
    }

    private void setLayoutManager() {
    }

    private void setDataSource() {
    }*/


}