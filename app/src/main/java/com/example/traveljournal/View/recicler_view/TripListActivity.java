package com.example.traveljournal.View.recicler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;

import java.util.ArrayList;
import java.util.List;

public class TripListActivity extends AppCompatActivity {

    private List<Trip> trips;
    private RecyclerView recyclerViewTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        recyclerViewTrips = findViewById(R.id.recyclerViewTrips);
        setupRecyclerViewTrips();
    }

    // step 1 : get data sources
    private void getTrips() {
        trips = new ArrayList<>();
        Trip trip1 = new Trip("Calatorie 1", "Roma");
        Trip trip2 = new Trip("Calatorie 2", "Madrid");
        Trip trip3 = new Trip("Calatorie 3", "New York");

        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);

    }

    // step 2 : get adapter
    private TripAdapter getTripsAdapter() {
        return new TripAdapter(trips);
    }

    // step 3 : map the adapter to the RecyclerView

    // step 3.1 : tells to the RecyclerView to display the items in a linear way (list style)
    private void setupLayoutManager() {
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(TripListActivity.this));
    }

    // step 3.2 : combine the code : populate data source, set LayoutManager, set adapter
    private void setupRecyclerViewTrips() {
        getTrips();
        setupLayoutManager();
        recyclerViewTrips.setAdapter(getTripsAdapter());
    }

}