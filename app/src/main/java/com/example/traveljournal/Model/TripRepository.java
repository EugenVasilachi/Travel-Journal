package com.example.traveljournal.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TripRepository {
    private TripDao tripDao;
    private LiveData<List<Trip>> trips;

    TripRepository(Application application) {
        TripRoomDatabase wordRoomDatabase = TripRoomDatabase.getDatabase(application);
        tripDao = wordRoomDatabase.tripDao();
        trips = tripDao.getTrips();
    }

    public LiveData<List<Trip>> getWords() {
        return trips;
    }

    // we must call this method on a different thread
    // it is a long running operations that should be done on a different thread than the UI(main) thread
    void insert(Trip trip) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.insert(trip);
        });
    }
}