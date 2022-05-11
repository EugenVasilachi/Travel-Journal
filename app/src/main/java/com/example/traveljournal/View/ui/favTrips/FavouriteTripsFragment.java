package com.example.traveljournal.View.ui.favTrips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.Controller.recicler_view.TripAdapter;
import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.Model.TripViewModel;
import com.example.traveljournal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FavouriteTripsFragment extends Fragment {
    private RecyclerView recyclerViewTrips;
    public static List<Trip> favTrips = new ArrayList<>();
    private TripViewModel favTripViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav_trips, container, false);
        favTripViewModel = new ViewModelProvider(this).get(TripViewModel.class);
        recyclerViewTrips = view.findViewById(R.id.recyclerViewFavTrips);
        setupRecyclerViewTrips();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
    }

    public static void setFavTrips(List<Trip> favTrips) {
        FavouriteTripsFragment.favTrips = favTrips;
    }

    private void getTrips() {
        /*favTrips = new ArrayList<>();
        String urlImage1 = "https://images.unsplash.com/photo-1496442226666-8d4d0e62e6e9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80";

        Trip trip1 = new Trip("Recommendation", "New York", "City Break", 2000, "05/05/2022", "10/05/2022", 5.0F, urlImage1);

        favTrips.add(trip1);*/

        favTripViewModel.getFavouriteTrips().observe(requireActivity(), trips -> setFavTrips(favTripViewModel.getFavouriteTrips().getValue()));

    }

    private TripAdapter getTripsAdapter() {
        return new TripAdapter(favTrips);
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
