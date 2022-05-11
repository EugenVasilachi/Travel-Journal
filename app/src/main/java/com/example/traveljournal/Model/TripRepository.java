package com.example.traveljournal.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TripRepository {
    private TripDao tripDao;
    private LiveData<List<Trip>> trips;
    private LiveData<List<Trip>> favTrips;

    TripRepository(Application application) {
        TripRoomDatabase wordRoomDatabase = TripRoomDatabase.getDatabase(application);
        tripDao = wordRoomDatabase.tripDao();
        trips = tripDao.getTrips();
        favTrips = tripDao.getFavouriteTrips();
    }

    public LiveData<List<Trip>> getTrips() {
        return trips;
    }

    // we must call this method on a different thread
    // it is a long running operations that should be done on a different thread than the UI(main) thread
    void insert(Trip trip) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.insert(trip);
        });
    }
    public LiveData<List<Trip>> getFavouriteTrips(){
        return favTrips;
    }

    public void updateFavourite(int id) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.updateFavourite(id);
        });
    }
}