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

    @SuppressLint("UseCompatLoadingForDrawables")
    private void getTrips() {
        trips = new ArrayList<>();
        Drawable image = getResources().getDrawable(R.drawable.newyork2);
        Drawable image2 = getResources().getDrawable(R.drawable.egipt);
        Drawable image3 = getResources().getDrawable(R.drawable.hunedoara);
        Drawable image4 = getResources().getDrawable(R.drawable.japonia);




        Trip trip1 = new Trip("Calatorie 1", "New York", "City Break", 200, "05/05/2022", "10/05/2022", 5.0F, image);
        Trip trip2 = new Trip("Calatorie 2", "Egipt", "City Break", 600, "15/07/2022", "20/07/2022", 5.0F, image2);
        Trip trip3 = new Trip("Calatorie 3", "Hunedoara", "City Break", 1000, "30/12/2022", "15/01/2023", 5.0F, image3);
        Trip trip4 = new Trip("Calatorie 4", "Japonia", "City Break", 1000, "30/12/2022", "15/01/2023", 5.0F, image4);

        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
        trips.add(trip4);
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