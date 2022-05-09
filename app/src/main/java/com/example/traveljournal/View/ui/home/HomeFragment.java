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

    @SuppressLint("UseCompatLoadingForDrawables")
    private void getTrips() {
        trips = new ArrayList<>();

        // trips = paramListOfTrips --> private/public static void getTrips(paramListOfTrips)
        // aceasta metoda va fi apelata de 2 ori :
        // o data in onCreate drawer acitivty
        // si "a 2 a" oara pentru fiecare adaugare
        // pentru adaugari real time trebuie sa facem ca ecranul add activity sa faca parte din nav
        // astfel scapam de problema cu ui threadul(nu va fi nevoie sa revenim la alt ecran, folosim navul)
        // nu va fi nevoie sa retrimitem controllerul
        // dupa fiecare adaugare/modificare vom modifica baza de date

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
    }

    private TripAdapter getTripsAdapter() {
        return new TripAdapter(trips);
    }


    private void setupLayoutManager() {
        recyclerViewTrips.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupRecyclerViewTrips() {
        // getTrips nu se va mai apela aici
        getTrips();
        setupLayoutManager();
        recyclerViewTrips.setAdapter(getTripsAdapter());
    }
}