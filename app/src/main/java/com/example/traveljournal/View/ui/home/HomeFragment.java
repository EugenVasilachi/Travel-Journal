package com.example.traveljournal.View.ui.home;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;
import com.example.traveljournal.Controller.recicler_view.TripAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewTrips;
    public static ArrayList<Trip> trips = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewTrips = view.findViewById(R.id.recyclerViewTrips);
        setupRecyclerViewTrips();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
    }

    private void getTrips() {
        trips = new ArrayList<>();
        String urlImage1 = "https://images.unsplash.com/photo-1496442226666-8d4d0e62e6e9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80";
        String urlImage2 = "https://images.unsplash.com/photo-1574864745093-5566c5be5855?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80";
        String urlImage3 = "https://images.unsplash.com/photo-1509713086752-a3747b6ee54a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1331&q=80";
        String urlImage4 = "https://images.unsplash.com/photo-1492571350019-22de08371fd3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1053&q=80";

        Trip trip1 = new Trip("Recomandation", "New York", "City Break", 2000, "05/05/2022", "10/05/2022", 5.0F, urlImage1);
        Trip trip2 = new Trip("Recomandation", "Egipt", "City Break", 2500, "15/07/2022", "20/07/2022", 5.0F, urlImage2);
        Trip trip3 = new Trip("Recomandation", "Hunedoara", "City Break", 100, "30/12/2022", "15/01/2023", 5.0F, urlImage3);
        Trip trip4 = new Trip("Recomandation", "Japonia", "City Break", 3500, "30/12/2022", "15/01/2023", 5.0F, urlImage4);

        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
        trips.add(trip4);
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