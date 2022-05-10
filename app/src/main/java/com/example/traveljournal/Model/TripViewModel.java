package com.example.traveljournal.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private TripRepository tripRepository;
    private LiveData<List<Trip>> trips;

    public TripViewModel(@NonNull Application application) {
        super(application);
        tripRepository = new TripRepository(application);
        trips = tripRepository.getWords();
    }

    public LiveData<List<Trip>> getTrips() {
        return trips;
    }

    public void insert(Trip trip) {
        tripRepository.insert(trip);
    }
}
