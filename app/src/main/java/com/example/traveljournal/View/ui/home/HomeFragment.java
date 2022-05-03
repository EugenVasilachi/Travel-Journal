package com.example.traveljournal.View.ui.home;

import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;
import com.example.traveljournal.View.recicler_view.TripAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewTrips;
    private List<Trip> trips;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewTrips = view.findViewById(R.id.recyclerViewTrips);
        setupRecyclerViewTrips();
        return view;
    }

    private void getTrips() {
        trips = new ArrayList<>();

       // Trip trip1 = new Trip("Calatorie 1", "New York", "City Break", 200, "05/05/2022", "10/05/2022", 5.0,  )

       // trips.add(trip1);
        //trips.add(trip2);
        //trips.add(trip3);
       // trips.add(trip4);

    }

    private TripAdapter getTripsAdapter() {
        return new TripAdapter(trips);
    }


    private void setupLayoutManager() {
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupRecyclerViewTrips() {
        getTrips();
        setupLayoutManager();
        recyclerViewTrips.setAdapter(getTripsAdapter());
    }
}